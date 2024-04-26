package com.couchcrafters.model;

import lombok.Data;
import org.json.JSONObject;
@Data
public class Book {

    private String _id;
    private String isbn;
    private String title;
 //   private String[] authors;
  //  private String publisher;
  //  private int publicationYear;
 //   private String genre;
//    private String language;
 //   private int pageCount;
  //  private boolean available;
 //   private double rating;
 //   private String description;
   // private double price;
   // private String coverImage; // Dateipfad zum Coverbild


 /*   public Book(String _id, String isbn, String title) {
        this._id = _id;
        this.isbn = isbn;
        this.title = title;
    }*/

    /*
        public Book(String _id,String isbn, String title, String[] authors, String publisher, int publicationYear, String genre,
                    String language, int pageCount, boolean available, double rating, String description, double price, String coverImage) {
            this._id = _id;
            this.isbn = isbn;
            this.title = title;
            this.authors = authors;
            this.publisher = publisher;
            this.publicationYear = publicationYear;
            this.genre = genre;
            this.language = language;
            this.pageCount = pageCount;
            this.available = available;
            this.rating = rating;
            this.description = description;
            this.price = price;
            this.coverImage = coverImage;
        }
    */
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
