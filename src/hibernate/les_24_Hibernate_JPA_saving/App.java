package com.mike.hibernate_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(2);
        student.setFirstName("Leonardo");
        student.setLastName("DiCaprio");
        student.setAge(57);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

        System.out.println(student);
    }
}
