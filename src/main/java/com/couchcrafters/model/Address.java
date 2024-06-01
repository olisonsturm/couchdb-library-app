package com.couchcrafters.model;

public class Address {
    public String street;
    public String city;

    public String housenumber;
    public String postCode;

    public Address(String street, String city, String postCode, String housenumber) {
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.housenumber = housenumber;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }
}
