package com.couchcrafters.service;

import com.couchcrafters.model.Book;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

public class BookService {
    public static String buchSpeichern(Book book) {

        CouchDbClient dbClient = new CouchDbClient();

        // UUID wird automatisch generiert
        Response response = dbClient.save(book);

        if (response.getError() == null) {
            System.out.println("Dokument wurde erfolgreich hinzugefügt. ID: " + response.getId());
        } else {
            System.err.println("Fehler beim Hinzufügen des Dokuments: " + response.getError());
        }
        dbClient.shutdown();
        return  book.get_id();
    }
}

