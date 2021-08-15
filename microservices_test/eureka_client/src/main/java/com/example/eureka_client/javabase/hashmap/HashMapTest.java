package com.example.eureka_client.javabase.hashmap;

import com.example.eureka_client.javabase.hashmap.impl.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        hashMapTest();
    }

    public static void hashMapTest(){
        Map<Object,Object> map = new HashMap<>();
        map.put("Monkey老师","我是monkey");
        map.put("愚者","愚者是一位好同学");
        System.out.println(map.get("Monkey老师"));
        System.out.println(map.get("愚者"));
    }
}
