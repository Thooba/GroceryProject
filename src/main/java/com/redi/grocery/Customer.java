package com.redi.grocery;

import java.time.LocalDate;
import java.util.UUID;

public class Customer{
    private final UUID custId;
    private final String name;
    private final String emailId;
    private final String password;
    private final LocalDate date;

//    constructor for existing user
    public Customer(UUID custId, String name, String emailId, String password, LocalDate date) {
        this.custId = custId;
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.date = date;
    }

//  for new user
    public Customer(String name, String emailId, String password) {
        this(UUID.randomUUID(), name, emailId, password, LocalDate.now());
    }

    public UUID getCustId() {
        return custId;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return custId + "," + name + "," + emailId + "," + password + "," + date;
    }

}

