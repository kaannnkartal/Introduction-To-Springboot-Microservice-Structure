package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Customer {
    @Id
    private int customerId;
    private String firstName;
    private String lastName;
    private Date birthOfDate;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "adressId")
    private Address address;

    public Customer(){}

    public Customer(String firstName, String lastName, Date birthOfDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthOfDate = birthOfDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
