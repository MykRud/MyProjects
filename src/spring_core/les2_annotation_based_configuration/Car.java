package com.mike.les2_annotation_based_configuration;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{
    @Override
    public void drive() {
        System.out.println("Car is in running");
    }
}
