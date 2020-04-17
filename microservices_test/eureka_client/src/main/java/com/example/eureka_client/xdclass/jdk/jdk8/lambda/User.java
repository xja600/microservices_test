package com.example.eureka_client.xdclass.jdk.jdk8.lambda;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
       private String name;
       private int age;

       public User(){

       }
       public User(String name,int age){
           this.age = age;
           this.name = name;
       }
    public User(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
