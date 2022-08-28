package com.mike.web.springbootweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping("home")
    public String home(HttpServletRequest request){
        String name = request.getParameter("name");
        HttpSession session = request.getSession(); // or request.setAttribute() in controller;
                                                    // request.getAttribute() in JSP
        session.setAttribute("name", name);
        return "home";
    }
}
