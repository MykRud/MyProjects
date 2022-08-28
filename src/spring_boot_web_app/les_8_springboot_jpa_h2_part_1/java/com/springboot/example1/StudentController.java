package com.springboot.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @Autowired
    private StudentRepo repo;

    @RequestMapping("/")
    public String getHome(){
        return "home.jsp";
    }

    @RequestMapping("addStudent")
    public ModelAndView getStudent(Student student){
        repo.save(student);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("student", student);

        return mv;
    }
}
