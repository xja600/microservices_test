package com.example.eureka_client.xdclass.jdk.jdk8.stream;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private int id;
    private String name;
    private String pwd;

    public User(){

    }
    public User(int id,String name ,String pwd){
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
}
