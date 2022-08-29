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

    // consumes can be added
    @PostMapping(path = "/student/form-data") // or method = RequestMethod.POST
    public Student addStudentFromData(Student student){
        repo.save(student);
        return student;
    }

    // consumes is not required
    @PostMapping(path = "/student/raw", consumes = {"application/json"})
    public Student addStudentRaw(@RequestBody Student student){
        repo.save(student);
        return student;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        return repo.findById(id).orElse(new Student());
    }
}
