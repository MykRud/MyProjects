package com.mike.les5_java_annotation_configuration;

public class Snapdragon implements MobileProcessor{
    @Override
    public void process() {
        System.out.println("Snapdragon is in processing");
    }
}
