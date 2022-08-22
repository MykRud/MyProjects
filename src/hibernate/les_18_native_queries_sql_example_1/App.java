package com.mike.hibernate;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration().configure().addAnnotatedClass(Person.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(reg);

        Session session = sf.openSession();
        session.beginTransaction();

        SQLQuery query = session.createSQLQuery("SELECT * FROM Person"); // NativeQuery is not deprecated
        query.addEntity(Person.class);
        List<Person> list = query.list();

        for(Person p : list)
            System.out.println(p.getId() + " : " + p.getName() + " : " + p.getAge());

        session.getTransaction().commit();
        session.close();

    }
}
