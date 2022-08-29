package com.springboot.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepo repo;

    @RequestMapping(path = "/getStudents", produces = {"application/xml"})
    @ResponseBody
    public List<Student> getStudents(){
        return repo.findAll();
    }

    @RequestMapping("/getStudent/{id}")
    @ResponseBody
    public Student getStudent(@PathVariable int id){
        return repo.findById(id).orElse(new Student());
    }
}
