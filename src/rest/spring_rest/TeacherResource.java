package com.springrestexample;

import com.springrestexample.model.Teacher;
import com.springrestexample.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("teachers")
public class TeacherResource {

    @Autowired
    private TeacherRepo teacherRepo;

    @GetMapping
    public List<Teacher> getTeachers(){
        return (List<Teacher>) teacherRepo.findAll();
    }

    @GetMapping("teacher/{id}")
    public Teacher getTeacher(@PathVariable("id") int id){
        Optional<Teacher> opt = teacherRepo.findById(id);
        return opt.orElseGet(Teacher::new);
    }

    @PostMapping("teacher")
    public void addTeacher(@RequestBody Teacher teacher){
        teacherRepo.save(teacher);
    }

    @PutMapping("teacher/{id}")
    public Teacher updateTeacher(@PathVariable("id") int id, @RequestBody Teacher teacher){
        Teacher foundTeacher = teacherRepo.findById(id).orElseGet(Teacher::new);
        teacherRepo.save(teacher);
        return foundTeacher;
    }

    @DeleteMapping("teacher/{id}")
    public Teacher deleteTeacher(@PathVariable("id") int id){
        Teacher foundTeacher = teacherRepo.findById(id).orElseGet(Teacher::new);
        if(foundTeacher.getId() != 0 ) teacherRepo.delete(foundTeacher);
        return foundTeacher;
    }

}
