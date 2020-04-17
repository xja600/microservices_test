package com.example.eureka_client.xdclass.jdk.jdk8.optional;

import javax.sound.midi.Soundbank;
import java.util.Optional;

/**
 * @Description : optional :主要解决空指针问题
 *  本质是一个包含有可选值的包装类，这意味着optional类既可以含有对象也可以为空
 * @author xinjunan
 * @date 2020/2/12 17:34
 */

public class Main {
    public static void main(String[] args) {
        try {
            Student student = new Student();
            Optional optional = Optional.ofNullable(student);//可能为空，也可能不为空
           // Optional optional = Optional.of(student);//不能为空
            if(optional.isPresent()){
                System.out.println("optional 不为空");
            }else{
                System.out.println("optional 为空");
            }

            Student student1 = null;
            Student student2 = new Student(2);
            // 兜底 如果student1 为空，则返回student2，否则返回student1
            Student result = optional.ofNullable(student1).orElse(student2);
            System.out.println("age:"+result);
            System.out.println("结果："+result.getAge());
            //与上面的方法是一样的效果
            int reult2 = Optional.ofNullable(student1).map(obj->obj.getAge()).orElse(7);
            System.out.println("age:"+reult2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
