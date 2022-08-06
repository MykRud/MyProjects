package com.mike.les1_application_context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("les1-spring.xml");

        Vehicle obj = (Vehicle)context.getBean("vehicle");
        obj.drive();
    }
}
