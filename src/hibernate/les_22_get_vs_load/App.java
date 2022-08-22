package com.mike.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration().configure().addAnnotatedClass(Person.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(reg);

        Session session = sf.openSession();
        session.beginTransaction();

        Person person1 = session.get(Person.class, 1); // it will give you Person object immediately
        
        Person person2 = session.load(Person.class, 1); // it will give you the Proxy object (blank object).
                                                        // it will not hit the query of fetching object at that moment

        System.out.println(person2.getName()); // Only now it will hit the query

        Person notFoundPerson1 = session.get(Person.class, 1000); // it will return null

        Person notFoundPerson2 = session.load(Person.class, 1000); // it will throw ObjectNotFoundException

        session.close();

    }
}
