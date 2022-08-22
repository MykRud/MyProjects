package com.mike.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Map;

public class App
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration().configure().addAnnotatedClass(Person.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(reg);

        Session session = sf.openSession();
        session.beginTransaction();

        Person person = new Person(); // state: new and transient
        person.setId(51);
        person.setName("Jaden");
        person.setAge(35);

        session.persist(person); // state: persistent
        person.setAge(24); // it will reflect in database, because the object is still in persistent state

        session.remove(person); // state: removed

        session.getTransaction().commit();

        // IF WE HAVEN'T REMOVED OBJECT
        session.detach(person); // not object is not in persistent state but in detached state
        // Btw, it's already detached (after commit() all objects get detached state).
        person.setAge(45); // state: detached. this changes will not affect database record

        session.close();

    }
}
