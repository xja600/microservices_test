package com.example.eureka_client.xdclass.jdk.jdk8.interfac;

/**
 * jdk8之前的版本 接口只能写抽象方法，不能有任何方法的实现，
 * jdk8新特性：使用default修饰方法，可以在接口里面写具体的方法实现
 *  使用场景：接口里面定义公用的业务逻辑，抽取出来，每个子类都必须具备
 * @author xinjunan
 * @date 2020/2/12 12:45
 * @Description:
 */

public interface Animal {
    void eat();
    void run();
    default void breath(){
        System.out.println("------测试default-呼吸------2");
    }
    static void test(){
        System.out.println("--这个是静态方法---");
    }
}
