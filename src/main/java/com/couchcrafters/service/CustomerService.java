package com.couchcrafters.service;

import com.couchcrafters.model.Book;
import com.couchcrafters.model.Customer;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import java.util.List;

public class CustomerService {
    private static CouchDbClient dbClient = new CouchDbClient("couchdb_customers.properties");
    public static void saveCustomer(Customer customer) {
        Response response = dbClient.save(customer);
        if (response.getError() == null) {
            System.out.println("Dokument wurde erfolgreich hinzugefügt. ID: " + response.getId());
        } else {
            System.err.println("Fehler beim Hinzufügen des Dokuments: " + response.getError());
        }
    }

    public static List<Book> getAllCustomers(){
        List<Book> customers = dbClient.view("_all_docs").includeDocs(true).query(Book.class);
        for(Book b : customers){
            System.out.println(b.getTitle());
        }
        return customers;
    }
}
