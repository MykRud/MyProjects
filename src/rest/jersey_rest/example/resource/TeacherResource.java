package org.example.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.example.model.Teacher;
import org.example.repo.TeacherRepo;

import java.util.List;

@Path("teachers")
public class TeacherResource {

    private final TeacherRepo teacherRepo;

    public TeacherResource(){
        teacherRepo = new TeacherRepo();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Teacher> getTeachers(){
        return teacherRepo.getAll();
    }

    @GET
    @Path("teacher/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Teacher getTeacher(@PathParam("id") int id){
        return teacherRepo.get(id);
    }

    @POST
    @Path("teacher")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public String addTeacher(Teacher teacher){
        teacherRepo.save(teacher);
        return "All is good!";
    }

    @PUT
    @Path("teacher/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Teacher updateTeacher(@PathParam("id") int id, Teacher teacher){
        return teacherRepo.update(id, teacher);
    }

    @DELETE
    @Path("teacher/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Teacher deleteTeacher(@PathParam("id") int id){
        return teacherRepo.delete(id);
    }

}
