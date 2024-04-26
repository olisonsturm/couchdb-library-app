package com.couchcrafters.model;

import lombok.Data;

@Data
public class Customer {

    // id
    private String _id;

    // attributs
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;

    public class Address {
        private String street;
        private String city;
        private String postCode;
    }

    public Customer() {}

    public Customer(String _id, String firstName, String lastName, String email, String phone, Address address) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
