package com.mike.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App
{
    public static void main( String[] args )
    {
        Person person = new Person();

        Person person1 = new Person();

        Configuration config = new Configuration().configure().addAnnotatedClass(Person.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(reg);

        // Same session
        Session session = sf.openSession();
        session.beginTransaction();

        person = session.get(Person.class, 1);
        person1 = session.get(Person.class, 1);

        session.getTransaction().commit();
        session.close();

        System.out.println(person);
        System.out.println(person1);
    }
}
