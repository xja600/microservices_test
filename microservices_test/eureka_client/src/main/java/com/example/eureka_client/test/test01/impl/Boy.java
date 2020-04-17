package com.example.eureka_client.test.test01.impl;

import com.example.eureka_client.test.test01.Father;
import org.springframework.stereotype.Component;


@Component
public class Boy implements Father {
    @Override
    public void eat() {
        System.out.println("  boy  est 1");
    }
}
