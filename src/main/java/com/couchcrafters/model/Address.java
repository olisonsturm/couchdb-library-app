package com.couchcrafters.model;

public class Address {
    public String street;
    public String city;
    public String postCode;

    public Address(String street, String city, String postCode) {
        this.street = street;
        this.city = city;
        this.postCode = postCode;
    }

    public Address() {

    }

}
