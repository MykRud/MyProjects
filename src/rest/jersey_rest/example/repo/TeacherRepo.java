package org.example.repo;

import org.example.model.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepo extends CommonRepo<Teacher>{

    @Override
    public Teacher get(int id) {
        Teacher teacher = new Teacher();
        try(PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM Teacher WHERE id=?")){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                teacher.setId(resultSet.getInt("id"));
                teacher.setFirstName(resultSet.getString("firstName"));
                teacher.setLastName(resultSet.getString("lastName"));
                teacher.setSubject(resultSet.getString("subject"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public List<Teacher> getAll() {
        List<Teacher> teachers = new ArrayList<>();
        try(Statement statement = getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Teacher");
            while (resultSet.next()){
                Teacher teacher = new Teacher();

                teacher.setId(resultSet.getInt("id"));
                teacher.setFirstName(resultSet.getString("firstName"));
                teacher.setLastName(resultSet.getString("lastName"));
                teacher.setSubject(resultSet.getString("subject"));

                teachers.add(teacher);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return teachers;
    }

    @Override
    public void save(Teacher entity) {
        String SQLQuery = "INSERT INTO Teacher(id, firstName, lastName, subject) " +
                "VALUES(?, ?, ?, ?)";
        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getFirstName());
            statement.setString(3, entity.getLastName());
            statement.setString(4, entity.getSubject());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Teacher update(int id, Teacher entity) {
        String SQLQuery = "UPDATE Teacher SET firstName=?, lastName=?, subject=? WHERE id=?";
        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getSubject());
            statement.setInt(4, id);

            int numberOfChanges = statement.executeUpdate();

            if(numberOfChanges == 0)
                return new Teacher();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public Teacher delete(int id) {
        Teacher foundTeacher = get(id);

        String SQLQuery = "DELETE FROM Teacher WHERE id=?";

        if(foundTeacher.getId() != 0){
            try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        return foundTeacher;
    }

}
