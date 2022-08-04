package org.example.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public abstract class CommonRepo<T> {

    private Connection connection;

    protected CommonRepo(){
        String url = "jdbc:mysql://localhost:3306/jerseyrestdb";
        String username = "root";
        String password = "MR!QAZ2wsx";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public abstract T get(int id);

    public abstract List<T> getAll();

    public abstract void save(T entity);

    public abstract T update(int id, T entity);

    public abstract T delete(int id);

    public Connection getConnection() {
        return connection;
    }

}
