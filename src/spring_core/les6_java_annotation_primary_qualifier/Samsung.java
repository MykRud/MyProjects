package com.mike.les6_java_annotation_primary_qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("mySamsung")
public class Samsung {

    @Autowired
    @Qualifier("snapdragon")
    private MobileProcessor cpu;

    public MobileProcessor getCpu() {
        return cpu;
    }

    public void setCpu(MobileProcessor cpu) {
        this.cpu = cpu;
    }

    public void config(){
        System.out.println("8 core CPU, 18 GB RAM, 32 MB Camera");
        cpu.process();
    }
}
