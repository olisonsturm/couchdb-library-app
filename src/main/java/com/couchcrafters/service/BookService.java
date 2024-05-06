package com.couchcrafters.service;

import com.couchcrafters.model.Book;
import com.google.gson.JsonObject;
import org.lightcouch.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {



    private static CouchDbClient dbClient = new CouchDbClient("couchdb_books.properties");
    public  void saveBook(Book book) {
        //Authoren spliten
        book.setAuthors(book.getAuthors()[0].split(";"));
        book.set_id(generateId());
        Response response = dbClient.save(book);
        if (response.getError() == null) {
            System.out.println("Dokument wurde erfolgreich hinzugefügt. ID: " + response.getId());
        } else {
            System.err.println("Fehler beim Hinzufügen des Dokuments: " + response.getError());
        }
    }

    public  List<Book> getAllBooks(){
        List<Book> books = dbClient.view("allBooks/allBooks").includeDocs(true).query(Book.class);
        for(Book b : books){
            System.out.println(b.getTitle());
        }
        return books;
    }
        public  List<Book> getAllBooksFiltered(String genre){
        List<Book> books = dbClient.view("genreSearch/genreSearch").key(genre).includeDocs(true).query(Book.class);
        for(Book b : books){
            System.out.println(b.getTitle());
        }
        return books;
    }

    public String generateId(){
        List<JsonObject> jsons = dbClient.view("idtoInt/idtoInt").query(JsonObject.class);

        JsonObject value = jsons.get(0).get("value").getAsJsonObject();
        int max = value.get("max").getAsInt();
        System.out.println(max);
        max += 1;
        return Integer.toString(max);
    }
    public List<JsonObject> getAllTitlesAndAuthors(){
        return dbClient.view("titleToId/titleToId").query(JsonObject.class);
    }
}

