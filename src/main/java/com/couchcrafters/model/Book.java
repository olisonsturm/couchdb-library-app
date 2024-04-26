package com.couchcrafters.model;

import lombok.Data;
import org.json.JSONObject;
@Data
public class Book {

    private String _id;


    private String title;
    private String[] authors;
    private String publisher;
    private String publishedYear;
    private String genre;
    private String rating;
    private String isbn;
    private String coverImage;
    private String amount;
    // private boolean available;

    public Book() {}

    public Book(String _id, String title, String[] authors, String publisher, String publishedYear, String genre, String rating, String isbn, String coverImage, String amount) {
        this._id = _id;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedYear = publishedYear;
        this.genre = genre;
        this.rating = rating;
        this.isbn = isbn;
        this.coverImage = coverImage;
        this.amount = amount;
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

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
