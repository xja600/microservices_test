package com.example.eureka_client.test;

import com.example.eureka_client.test.test01.Father;
import com.example.eureka_client.test.test01.impl.Boy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class test {

    @Autowired
    private Father father;

    public static void main(String[] args) {
        /*Map<String,String> hash = new HashMap<String,String>();
        hash.put("a","1");
        hash.put("b","2");
        hash.put("a","2");

        System.out.println(hash);

        List arrayList =  new ArrayList<>(10);

        arrayList.add("1");*/
        //Collections.synchronizedCollection(arrayList);

        testHashMap();
    }

    @Test
    public void test(){
        Father father = new Boy();
        father.eat();
//        father.eat();
//        System.out.println(boy.eat(););
    }

    /**
     * hashMap测试类
     */
    public static void testHashMap(){
        String key = "abc";

        //获取key的hashCode值
        System.out.println(key.hashCode());
    }
}
