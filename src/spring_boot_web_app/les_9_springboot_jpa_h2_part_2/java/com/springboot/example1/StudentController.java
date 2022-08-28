package com.springboot.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepo repo;

    @RequestMapping("/")
    public String getHome(){
        return "home";
    }

    @RequestMapping("addStudent")
    public ModelAndView addStudent(Student student){
        repo.save(student);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("student", student);

        return mv;
    }

    @RequestMapping("/getStudent")
    public ModelAndView getStudent(@RequestParam int id){
        Student student = repo.findById(id).orElse(new Student());

        ModelAndView mv = new ModelAndView("result");
        mv.addObject("student", student);

        return mv;
    }
}
