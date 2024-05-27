package com.couchcrafters.service;

import com.couchcrafters.model.Lending;
import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LendService {
    private static final CouchDbClient bookClient = new CouchDbClient("couchdb_books.properties");
    private static final CouchDbClient customerClient = new CouchDbClient("couchdb_customers.properties");
    private static final CouchDbClient lendClient = new CouchDbClient("couchdb_lendings.properties");




    public boolean saveLending(Lending lending){

        lending.set_id(generateId());

        lending.setBook_id(lending.getBook_id().replace("\"", ""));
        lending.setCustomer_id(lending.getCustomer_id().replace("\"", ""));


        if(checkAvailable(lending.getBook_id())){
            Response response = lendClient.save(lending);
            if (response.getError() == null) {
                System.out.println("Dokument wurde erfolgreich hinzugefügt. ID: " + response.getId());
            } else {
                System.err.println("Fehler beim Hinzufügen des Dokuments: " + response.getError());
            }
            return true;
        } else{
            return false;
        }
    }
    public String generateId(){
        List<JsonObject> jsons = lendClient.view("idtoInt/idtoInt").query(JsonObject.class);
        JsonObject value = jsons.get(0).get("value").getAsJsonObject();
        int max = value.get("max").getAsInt();
        max += 1;
        return Integer.toString(max);
    }

    public boolean checkAvailable(String id ){

        List<JsonObject> books = bookClient.view("idToAmount/idToAmount").key(id).query(JsonObject.class);
        List<JsonObject> lendings = lendClient.view("countBooksForId/countBooksForIdThatAreFalse").key(id).query(JsonObject.class);

        //entweder es gibt keine Ausleihen dazu, oder er Benutzt die anzahl der Ausgeliehenen bücher und die amount
        if((lendings.size() == 0 )|| (books.get(0).get("value").getAsInt() < lendings.get(0).get("value").getAsInt())){
            return  true;
        }else {
            return false;
        }
    }

    public void updateLend(String  lendingid){
        lendingid = lendingid.replace("\"", "");
        Lending lend = lendClient.find(Lending.class,lendingid);
        lend.setReturnDate(String.valueOf(new Date()));
        lend.setReturnedBoolean(true);

        System.out.println(lend.toString());

     Response response  = lendClient.update(lend);
        if (response.getError() == null) {
            System.out.println("Dokument wurde geändert " + response.getId());
        } else {
            System.err.println("Fehler beim Ändern des Dokuments: " + response.getError());
        }
    }

    public List<JsonObject> getAllCurrentLends(){
        return lendClient.view("allUnreturnedLends/allUnreturnedLends").query(JsonObject.class);
    }

    public List<Lending> getAllLends(){
        return lendClient.view("allLends/allLends").includeDocs(true).query(Lending.class);
    }

    public List<Lending> getALlFilteredLends(boolean lended){
        return lendClient.view("allLends/allBooleanFilter").key(lended).includeDocs(true).query(Lending.class);
    }
    public int getFilteredLendCount(boolean lended){

        List<JsonObject> jsons = lendClient.view("allLends/allFilteredCount").key(lended).query(JsonObject.class);
        return jsons.get(0).get("value").getAsInt();
    }

    public List<JsonObject> mostLendedBooks() {
        List<JsonObject> books = lendClient.view("mostLendedBook/mostLendedBook")
                .group(true)
                .query(JsonObject.class);

        return books.stream()
                .sorted((a, b) -> Integer.compare(b.get("value").getAsInt(), a.get("value").getAsInt()))
                .limit(3)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        List<JsonObject> jsons = lendClient.view("allLends/allFilteredCount").key(true).query(JsonObject.class);

    }
}

