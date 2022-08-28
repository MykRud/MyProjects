package com.mike.web.springbootweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping("home")
    public String home(String name, HttpSession session){ // request can only have one param with name "name"
        session.setAttribute("name", name);
        return "home";
    }
}
