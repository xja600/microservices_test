package com.example.eureka_client.xdclass.jdk.jdk8;

import com.example.eureka_client.xdclass.jdk.jdk8.interfac.Animal;
import com.example.eureka_client.xdclass.jdk.jdk8.interfac.Dog;

public class Main {
    public static void main(String[] args) {
            Dog dog = new Dog();
            dog.eat();
            dog.run();
            dog.breath();
            Animal.test();
    }
}
