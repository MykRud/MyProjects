package com.mike.hibernate;

import com.mike.hibernate_relations.Student;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

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

        NativeQuery query = session.createSQLQuery("SELECT name, age FROM Person")
                .addScalar("name", new StringType())
                .addScalar("age", new IntegerType()); // Btw, it will also return Objects, not String or Integer
        List<Object[]> list = query.list();

        for(Object[] o : list) {
            System.out.println(o[0] + " : " + o[1]);
        }

        session.getTransaction().commit();
        session.close();

    }
}
