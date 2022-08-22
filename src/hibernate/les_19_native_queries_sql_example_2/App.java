package com.mike.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
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

        SQLQuery query = session.createSQLQuery("SELECT name, age FROM Person"); // NativeQuery is not deprecated
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); // setResultTransformer is deprecated
        List list = query.list();

        for(Object o : list) {
            Map m = (Map) o;
            System.out.println(m.get("name") + " : " + m.get("age"));
        }

        session.getTransaction().commit();
        session.close();

    }
}
