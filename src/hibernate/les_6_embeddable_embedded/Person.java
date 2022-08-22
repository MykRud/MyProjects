package com.mike.hibernate;

import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    private int id;
    @Embedded
    private PersonName name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonName getName() {
        return name;
    }

    public void setName(PersonName name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", " + name.toString() +
                ", age=" + age;
    }
}
