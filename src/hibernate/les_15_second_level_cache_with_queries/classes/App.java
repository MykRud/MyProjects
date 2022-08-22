package com.mike.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
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

        Query<Person> q1 = session.createQuery("FROM Person WHERE id=1");
        q1.setCacheable(true);
        person = q1.uniqueResult();

        session.getTransaction().commit();
        session.close();

        Session session1 = sf.openSession();
        session1.beginTransaction();

        Query<Person> q2 = session1.createQuery("FROM Person WHERE id=1");
        q2.setCacheable(true);
        person1 = q2.uniqueResult();

        session1.getTransaction().commit();
        session1.close();

        System.out.println(person);
        System.out.println(person1);
    }
}
