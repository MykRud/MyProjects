package com.mike.les2_annotation_based_configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("les2-spring.xml");

        Vehicle obj = (Vehicle) context.getBean("car");
        obj.drive();
    }
}
