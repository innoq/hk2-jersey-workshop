package com.innoq.uebung1.beans;

public class PersonService {
    private String firstName;

    public PersonService(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }
}
