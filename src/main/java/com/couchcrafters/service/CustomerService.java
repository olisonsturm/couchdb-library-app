package com.couchcrafters.service;

import com.couchcrafters.model.Address;
import com.couchcrafters.model.Book;
import com.couchcrafters.model.Customer;
import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {

    private static final CouchDbClient dbClient = new CouchDbClient("couchdb_customers.properties");
  
    public  void saveCustomer(Customer customer) {

        customer.setId(generateId());
        Response response = dbClient.save(customer);
        if (response.getError() == null) {
            System.out.println("Dokument wurde erfolgreich hinzugefügt. ID: " + response.getId());
        } else {
            System.err.println("Fehler beim Hinzufügen des Dokuments: " + response.getError());
        }
    }


    public List<Customer> getAllCustomers(){
        List<Customer> customers = dbClient.view("_all_docs").includeDocs(true).query(Customer.class);
        for(Customer c : customers){
            System.out.println(c.getId());
        }
        return customers;
    }
    public String generateId(){
        List<JsonObject> jsons = dbClient.view("idtoInt/idtoInt").query(JsonObject.class);
        JsonObject value = jsons.get(0).get("value").getAsJsonObject();
        int max = value.get("max").getAsInt();
        System.out.println(max);
        max += 1;
        return Integer.toString(max);
    }
    public List<JsonObject> getAllNamesAndEmails(){
        return dbClient.view("nameToId/nameToId").query(JsonObject.class);
    }


}
