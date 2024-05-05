package com.couchcrafters.model;

import lombok.Data;

@Data
public class Lending {

    // id
    private String _id;

    private String _rev;

    // foreign keys
    private String book_id;
    private String customer_id;

    // attributs
    private String lendDate;
    private String returnDate;
    private Boolean returnedBoolean;

    public Lending() {}



    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getLendDate() {
        return lendDate;
    }

    public void setLendDate(String lendDate) {
        this.lendDate = lendDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Boolean getReturnedBoolean() {
        return returnedBoolean;
    }

    public void setReturnedBoolean(Boolean returnedBoolean) {
        this.returnedBoolean = returnedBoolean;
    }

    public Lending(String _id, String _rev, String book_id, String customer_id, String lendDate, String returnDate, Boolean returnedBoolean) {
        this._id = _id;
        this._rev = _rev;
        this.book_id = book_id;
        this.customer_id = customer_id;
        this.lendDate = lendDate;
        this.returnDate = returnDate;
        this.returnedBoolean = returnedBoolean;
    }

    @Override
    public String toString() {
        return "Lending{" +
                "_id='" + _id + '\'' +
                ", _rev='" + _rev + '\'' +
                ", book_id='" + book_id + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", lendDate='" + lendDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", returnedBoolean=" + returnedBoolean +
                '}';
    }
}
