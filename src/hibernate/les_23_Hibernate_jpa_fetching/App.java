package com.mike.hibernate_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pa");
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, 1);
        System.out.println(student);
    }
}
