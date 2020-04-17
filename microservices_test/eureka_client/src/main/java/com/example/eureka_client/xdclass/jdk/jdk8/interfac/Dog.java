package com.example.eureka_client.xdclass.jdk.jdk8.interfac;

import com.example.eureka_client.xdclass.jdk.jdk8.interfac.Animal;

public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("--dog 吃东西---");
    }

    @Override
    public void run() {
        System.out.println("---dog 跑步----");
    }
}
