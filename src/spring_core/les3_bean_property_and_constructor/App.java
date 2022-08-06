package com.mike.les3_bean_property_and_constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("les3-spring.xml");

        Tyre mrf = (Tyre) context.getBean("tyre");
        System.out.println(mrf);
    }
}
