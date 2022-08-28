package com.mike.web.springbootweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping("home")
    public ModelAndView home(Student student){
        ModelAndView mv = new ModelAndView();
        mv.addObject("obj", student);
        mv.setViewName("home");
        return mv;
    }
}
