package com.springrestexample;

import com.springrestexample.model.Student;
import com.springrestexample.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentResource {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping
    public List<Student> getStudents(){
        return (List<Student>) studentRepo.findAll();
    }

    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable("id") int id){
        return studentRepo.findById(id).orElseGet(Student::new);
    }

    @PostMapping("student")
    public void addStudent(@RequestBody Student student){
        studentRepo.save(student);
    }

    @PutMapping("student/{id}")
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student){
        Student foundStudent = studentRepo.findById(id).orElseGet(Student::new);
        studentRepo.save(student);
        return foundStudent;
    }

    @DeleteMapping("student/{id}")
    public Student deleteStudent(@PathVariable("id") int id){
        Student foundStudent = studentRepo.findById(id).orElseGet(Student::new);
        if(foundStudent.getId() != 0 ) studentRepo.delete(foundStudent);
        return foundStudent;
    }

}
