package com.couchcrafters.service;

import com.couchcrafters.model.Book;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    private static CouchDbClient dbClient = new CouchDbClient("couchdb_books.properties");
    public  void saveBook(Book book) {
        //Authoren spliten
        book.setAuthors(book.getAuthors()[0].split(";"));
        Response response = dbClient.save(book);
        if (response.getError() == null) {
            System.out.println("Dokument wurde erfolgreich hinzugefügt. ID: " + response.getId());
        } else {
            System.err.println("Fehler beim Hinzufügen des Dokuments: " + response.getError());
        }


    }

    public  List<Book> getAllBooks(){
        List<Book> books = dbClient.view("_all_docs").includeDocs(true).query(Book.class);
        for(Book b : books){
            System.out.println(b.getTitle());
        }

        return books;
    }
}

