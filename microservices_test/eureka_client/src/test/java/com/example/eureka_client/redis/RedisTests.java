package com.example.eureka_client.redis;

import com.alibaba.fastjson.JSONObject;
import com.example.eureka_client.EurekaClientApplicationTests;
import com.example.eureka_client.service.redis.RedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RedisTests extends EurekaClientApplicationTests {

    /**
     * 在这里先是用@Autowired注解把redisService注入进来，然后由于是使用json字符串进行交互，所以引入fastjson的JSONObject类。然后为了方便，直接在这个测试类里面加了一个Person的内部类。
     *
     * 一共测试了：对于string类型的存取，对于object类型的存取，对于list类型的存取，其实本质都是转成了json字符串。还有就是根据key来执行remove操作。
     *
     * 作者：你想要怎样的未来
     * 链接：https://www.jianshu.com/p/19628db2e7ef
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    private JSONObject json = new JSONObject();

    @Autowired
    private RedisService redisService;

    @Test
    public void contextLoads() /*throws Exception*/ {
    }


    /**
     * 插入字符串
     */
    @Test
    public void setString() {
        redisService.set("redis_string_test", "springboot redis test");
    }

    /**
     * 获取字符串
     */
    @Test
    public void getString() {
        String result = redisService.get("redis_string_test");
        System.out.println("------------redis getString："+result);
    }

    /**
     * 插入对象
     */
    @Test
    public void setObject() {
        Person person = new Person("person", "male");
        redisService.set("redis_obj_test", json.toJSONString(person));
    }

    /**
     * 获取对象
     */
    @Test
    public void getObject() {
        String result = redisService.get("redis_obj_test");
        Person person = json.parseObject(result, Person.class);
        System.out.println("------------redis getObject："+json.toJSONString(person));
    }

    /**
     * 插入对象List
     */
    @Test
    public void setList() {
        Person person1 = new Person("person1", "male");
        Person person2 = new Person("person2", "female");
        Person person3 = new Person("person3", "male");
        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        redisService.set("redis_list_test", json.toJSONString(list));
    }

    /**
     * 获取list
     */
    @Test
    public void getList() {
        String result = redisService.get("redis_list_test");
        List<String> list = json.parseArray(result, String.class);
        System.out.println(list);
    }

    /**
     * 插入hash值
     */
    @Test
    public void setHash() {
        boolean reuslt = redisService.setHash("user_01","userName","xja");
        System.out.println("------------redis setHash："+reuslt);
    }

    /**
     * 获取getHash
     */
    @Test
    public void getHash() {
        Object result = redisService.getHash("user_01","userName");

        System.out.println("------------redis getHash："+result);
    }

    @Test
    public void remove() {
        redisService.remove("redis_test");
    }

}

class Person {
    private String name;
    private String sex;

    public Person() {

    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
