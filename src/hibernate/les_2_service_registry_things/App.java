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
        person.setId(1);
        person.setFirstName("Bruce");
        person.setLastName("Wayne");
        person.setAge(35);

        Configuration config = new Configuration().configure().addAnnotatedClass(Person.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        SessionFactory sf = config.buildSessionFactory(reg);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(person); // persist() - not deprecated

        tx.commit();
    }
}
