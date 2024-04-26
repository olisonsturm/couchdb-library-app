package com.couchcrafters.service;

import com.couchcrafters.model.Book;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Page;
import org.lightcouch.Response;

import java.util.List;

public class BookService {
   static CouchDbClient dbClient = new CouchDbClient();
    public static String buchSpeichern(Book book) {
        //Authoren spliten
        book.setAuthors(book.getAuthors()[0].split(";"));
        Response response = dbClient.save(book);
        if (response.getError() == null) {
            System.out.println("Dokument wurde erfolgreich hinzugefügt. ID: " + response.getId());
        } else {
            System.err.println("Fehler beim Hinzufügen des Dokuments: " + response.getError());
        }
        dbClient.shutdown();
        return  book.get_id();
    }

    public static List<Book> getAllBooks(){
        List<Book> books = dbClient.view("_all_docs").includeDocs(true).query(Book.class);
        for(Book b : books){
            System.out.println(b.getTitle());
        }
        return books;
    }



}

