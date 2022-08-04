package org.example.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.example.model.Student;
import org.example.repo.StudentRepo;

import java.util.List;

@Path("students")
public class StudentResource {

    private final StudentRepo studentRepo;

    public StudentResource(){
        studentRepo = new StudentRepo();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> getStudents(){
        return studentRepo.getAll();
    }

    @GET
    @Path("student/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Student getStudent(@PathParam("id") int id){
        return studentRepo.get(id);
    }

    @POST
    @Path("student")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public String addStudent(Student student){
        studentRepo.save(student);
        return "All is good!";
    }

    @PUT
    @Path("student/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Student updateStudent(@PathParam("id") int id, Student student){
        return studentRepo.update(id, student);
    }

    @DELETE
    @Path("student/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Student deleteStudent(@PathParam("id") int id){
        return studentRepo.delete(id);
    }

}
