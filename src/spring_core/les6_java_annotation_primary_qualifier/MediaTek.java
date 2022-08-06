package com.mike.les6_java_annotation_primary_qualifier;

import org.springframework.stereotype.Component;

@Component
public class MediaTek implements MobileProcessor{

    @Override
    public void process() {
        System.out.println("MediaTek is in processing");
    }
}
