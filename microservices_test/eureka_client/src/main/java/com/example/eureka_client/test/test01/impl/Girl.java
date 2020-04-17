package com.example.eureka_client.test.test01.impl;

import com.example.eureka_client.test.test01.Father;
import org.springframework.stereotype.Component;

@Component
public class Girl implements Father {
    @Override
    public void eat() {
        System.out.println(" girl eat 2");
    }
}
