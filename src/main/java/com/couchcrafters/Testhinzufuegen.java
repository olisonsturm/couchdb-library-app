package com.couchcrafters;

import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

public class Testhinzufuegen {
    public static String buchSpeichern(Book book) {

        CouchDbClient dbClient = new CouchDbClient();

        //Automatische ID generieren

        book.set_id("2102");
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

