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

    @RequestMapping("/getStudent")
    public ModelAndView getStudent(@RequestParam int id){
        Student student = repo.findById(id).orElse(new Student());

        ModelAndView mv = new ModelAndView("result");
        mv.addObject("student", student);

        System.out.println("Find By Age: ");
        List<Student> list = repo.findByAge(50);
        System.out.println(list);
        System.out.println("\nFind larger than id: ");
        List<Student> list1 = repo.findByIdLargerThan(2);
        System.out.println(list1);
        System.out.println("\nFind larger than age sorted by id: ");
        List<Student> list2 = repo.findByAgeSorted(50);
        System.out.println(list2);

        return mv;
    }
}
