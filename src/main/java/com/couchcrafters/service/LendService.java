package com.couchcrafters.service;

import com.couchcrafters.model.Book;
import com.couchcrafters.model.Lending;
import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;
import org.lightcouch.View;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public static void main(String[] args) {
        String id = "1002";
        List<JsonObject> books = bookClient.view("idToAmount/idToAmount").key(id).query(JsonObject.class);
        List<JsonObject> lendings = lendClient.view("countBooksForId/countBooksForIdThatAreFalse").key(id).query(JsonObject.class);

        if((lendings.size() == 0 )|| (books.get(0).get("value").getAsInt() < lendings.get(0).get("value").getAsInt())){
            System.out.println("Ja kann man machen");
        }else {
            System.out.println("bsit du duumm");
        }

    }

}
