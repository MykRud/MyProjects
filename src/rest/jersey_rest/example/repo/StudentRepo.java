package org.example.repo;

import org.example.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo extends CommonRepo<Student>{

    @Override
    public Student get(int id) {
        Student student = new Student();
        try(PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM Student WHERE id=?")){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setCourse(resultSet.getInt("course"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try(Statement statement = getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Student");
            while (resultSet.next()){
                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setCourse(resultSet.getInt("course"));

                students.add(student);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void save(Student entity) {
        String SQLQuery = "INSERT INTO Student(id, firstName, lastName, course) " +
                "VALUES(?, ?, ?, ?)";
        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getFirstName());
            statement.setString(3, entity.getLastName());
            statement.setInt(4, entity.getCourse());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Student update(int id, Student entity) {
        String SQLQuery = "UPDATE Student SET firstName=?, lastName=?, course=? WHERE id=?";
        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setInt(3, entity.getCourse());
            statement.setInt(4, id);

            int numberOfChanges = statement.executeUpdate();

            if(numberOfChanges == 0)
                return new Student();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public Student delete(int id) {
        Student foundStudent = get(id);

        String SQLQuery = "DELETE FROM Student WHERE id=?";

        if(foundStudent.getId() != 0){
            try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        return foundStudent;
    }

}
