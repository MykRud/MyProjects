package com.mike.les5_java_annotation_configuration;

import org.springframework.beans.factory.annotation.Autowired;

public class Samsung {

    @Autowired
    private MobileProcessor processor;

    public MobileProcessor getProcessor() {
        return processor;
    }

    public void setProcessor(MobileProcessor processor) {
        this.processor = processor;
    }

    public void config(){
        System.out.println("8 core processor, 16 GB RAM, 32 MP camera");
        processor.process();
    }
}
