package com.couchcrafters.service;

import com.couchcrafters.model.Book;
import com.couchcrafters.model.Lending;
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


  /*  public static void main(String[] args) {
        View view = bookClient.view("idAndTitle/getAllBooksWithTitle").includeDocs(true);;
        List<Book> books = view.query(Book.class);
        for(Book b : books){
            System.out.println(b.getTitle());
            System.out.println(b.get_id());
        }
    } */

    public void saveLending(Lending lending){
        Response response = lendClient.save(lending);
        if (response.getError() == null) {
            System.out.println("Dokument wurde erfolgreich hinzugefügt. ID: " + response.getId());
        } else {
            System.err.println("Fehler beim Hinzufügen des Dokuments: " + response.getError());
        }

    }
}
