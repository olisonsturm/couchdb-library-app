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


    public void updateBook(String bookId, String newTitle, String[] newAuthors, String newPublisher, String newISBN, String genre, double rating) {
        // Find the book by its ID
        Book bookToBeUpdated = dbClient.find(Book.class, bookId);

        // Update the book's properties with the new values
        if (newTitle != null && !newTitle.isEmpty()) {
            bookToBeUpdated.setTitle(newTitle);
        }
        if (newAuthors != null && newAuthors.length > 0) {
            bookToBeUpdated.setAuthors(newAuthors);
        }
        if (newPublisher != null && !newPublisher.isEmpty()) {
            bookToBeUpdated.setPublisher(newPublisher);
        }
        if (newISBN != null && !newISBN.isEmpty()) {
            bookToBeUpdated.setIsbn(newISBN);
        }

        bookToBeUpdated.setRating(rating);

        if (genre != null && !genre.isEmpty()) {
            bookToBeUpdated.setGenre(genre);
        }

        System.out.println(bookToBeUpdated.toString());

        Response response = dbClient.update(bookToBeUpdated);
        if (response.getError() == null) {
            System.out.println("Buchdaten wurden geändert. ID: " + response.getId());
        } else {
            System.err.println("Fehler beim Ändern des Buches: " + response.getError());
        }
    }

        public  List<Book> getAllBooksFiltered(String genre){
            List<Book> books = dbClient.view("genreSearch/genreSearch").key(genre).includeDocs(true).query(Book.class);
        for(Book b : books){
            System.out.println(b.getTitle());
        }
        return books;
    }

    public  List<Book> getAllBooksFilteredByPublisher(String publisher){
        List<Book> books = dbClient.view("publisherSearch/publisherSearch").key(publisher).includeDocs(true).query(Book.class);
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

    public List<JsonObject> groupGenres(){
        return  dbClient.view("genreSearch/groupGenre").group(true).query(JsonObject.class);

    }

    public static void main(String[] args) {
        List<JsonObject> jsonObjects = dbClient.view("genreSearch/groupGenre").group(true).query(JsonObject.class);
        for(JsonObject b : jsonObjects){
            System.out.println(b.get("key"));
            System.out.println(b.get("value"));
        }
    }
}

