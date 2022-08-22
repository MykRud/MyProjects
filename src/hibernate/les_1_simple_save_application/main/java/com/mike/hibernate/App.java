package com.mike.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
        Person person = new Person();
        person.setId(2);
        person.setFirstName("Bruce");
        person.setLastName("Wayne");
        person.setAge(35);

        Configuration config = new Configuration().configure().addAnnotatedClass(Person.class);

        SessionFactory sf = config.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(person); // persist() - not deprecated

        tx.commit();
    }
}
