package com.springboot.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo repo;

    @RequestMapping(path = "/students", produces = {"application/xml"}, method = RequestMethod.GET)
    public List<Student> getStudents(){
        return repo.findAll();
    }

    @PostMapping(path = "/student", consumes = {"application/json"})
    public Student addStudentRaw(@RequestBody Student student){
        repo.save(student);
        return student;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        return repo.findById(id).orElse(new Student());
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id){
        Student student = repo.getOne(id);

        repo.delete(student);

        return "deleted";
    }

    @PutMapping(path = "/student", consumes = {"application/json"})
    public Student saveOrUpdateStudent(@RequestBody Student student){
        repo.save(student);

        return student;
    }

}
