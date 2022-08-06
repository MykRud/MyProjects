package com.mike.les6_java_annotation_primary_qualifier;

import com.mike.les6_java_annotation_primary_qualifier.MobileProcessor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Snapdragon implements MobileProcessor {

    @Override
    public void process(){
        System.out.println("Snapdragon is in processing");
    }

}
