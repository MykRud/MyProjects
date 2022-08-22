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

        // Allies
        //Query<Object[]> q1 = session.createQuery("SELECT id, name, age FROM Person p WHERE p.age>60");
        //List<Object[]> persons = q1.list();
        //for(Object[] person : persons)
          //  System.out.println(person[0] + " : " + person[1] + " : " + person[2]);

        // Sum:
        //Query<Long> q1 = session.createQuery("SELECT sum(age) FROM Person WHERE age>50");
        //Long sum = q1.uniqueResult();

        // Prepared Statement:
        //int b = 50;
        //Query<Long> q1 = session.createQuery("SELECT sum(age) FROM Person WHERE age>"+b);
        //Long sum = q1.uniqueResult();
        //System.out.println(sum);
                  //          OR
        //Query<Long> q2 = session.createQuery("SELECT sum(age) FROM Person WHERE age>:b");
        //q2.setParameter("b", b);
        //Long sum1 = q1.uniqueResult();
        //System.out.println(sum1);

        session.getTransaction().commit();
        session.close();

    }
}
