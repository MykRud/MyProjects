package com.mike.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Random;

public class App
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration().configure().addAnnotatedClass(Person.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(reg);

        // Same session
        Session session = sf.openSession();
        session.beginTransaction();

        // Get all records:
        //Query<Person> q1 = session.createQuery("FROM Person");
        //List<Person> persons = q1.list();

        // Get records with condition:
        //Query<Person> q1 = session.createQuery("FROM Person WHERE age > 50");
        //List<Person> persons = q1.list();

        // Get unique result (specific record)
        //Query<Person> q1 = session.createQuery("FROM Person WHERE id=1");
        //Person person = q1.uniqueResult();

        // It will give a list of Objects, not Persons. ERROR!
        // Query<Person> q1 = session.createQuery("SELECT id, name, age FROM Person");
        // List<Person> persons = q1.list(); // or uniqueResult()
        // NOT ERROR:
        // List<Object[]> persons = q1.list() // or Object[] for uniqueResult()


        session.getTransaction().commit();
        session.close();

    }
}
