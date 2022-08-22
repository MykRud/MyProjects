package com.mike.hibernate;

import jakarta.persistence.*;

@Entity(name = "person_table")
@Table(name = "person_tab")
public class Person {
    @Id
    private int id;
    @Column(name = "first_name_of_person")
    private String firstName;
    @Transient
    private String lastName;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
