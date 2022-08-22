package com.mike.hibernate;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class PersonName {
    private String firstName;
    private String lastName;
    private String middleName;

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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return "First name='" + firstName + '\'' +
                ", Last name='" + lastName + '\'' +
                ", Middle name='" + middleName + '\'' +
                '}';
    }
}
