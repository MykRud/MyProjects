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
        PersonName name = new PersonName();
        name.setFirstName("Mike");
        name.setLastName("Jordan");
        name.setMiddleName("Johnovich");

        Person person = new Person();
        person.setId(1);
        person.setAge(56);
        person.setName(name);

        Configuration config = new Configuration().configure().addAnnotatedClass(Person.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        SessionFactory sf = config.buildSessionFactory(reg);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.persist(person);

        tx.commit();

        System.out.println(person);
    }
}
