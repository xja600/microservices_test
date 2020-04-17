package com.example.eureka_client.xdclass.jdk.jdk8.stream;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    private int userId;
    private String userName;

    public UserDTO(){

    }
    public UserDTO(int id, String name){
        this.userId = id;
        this.userName = name;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
