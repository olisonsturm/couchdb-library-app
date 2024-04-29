package com.couchcrafters.model;

import lombok.Data;
import org.json.JSONObject;

import java.util.Arrays;

@Data
public class Book {

    private String _id;
    private int amount;
    private String isbn;
    private String title;
    private String[] authors;
    private String publisher;
    private int publicationYear;
    private String genre;
    private double rating;


    public Book(String _id, int amount, String isbn, String title, String[] authors, String publisher, int publicationYear, String genre, double rating) {
        this._id = _id;
        this.amount = amount;
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.rating = rating;
    }

    public Book() {

    }



    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "_id='" + _id + '\'' +
                ", amount=" + amount +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", publisher='" + publisher + '\'' +
                ", publicationYear=" + publicationYear +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}

