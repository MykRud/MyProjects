package com.springrestexample.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Student {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private int course;
}
