package com.mike.hibernate_relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setLid(1);
        laptop.setName("DEL");

        Laptop laptop1 = new Laptop();
        laptop1.setLid(2);
        laptop.setName("Asus");

        Student student = new Student();
        student.setId(101);
        student.setName("Mike");
        student.getLaptops().add(laptop);
        student.getLaptops().add(laptop1);

        laptop.getStudents().add(student);
        laptop1.getStudents().add(student);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        SessionFactory factory = configuration.buildSessionFactory(reg);

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(laptop);
        session.persist(laptop1);
        session.persist(student);

        transaction.commit();

    }
}
