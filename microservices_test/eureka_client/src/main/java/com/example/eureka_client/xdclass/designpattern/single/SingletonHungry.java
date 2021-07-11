package com.example.eureka_client.xdclass.designpattern.single;

/**
 * 小滴课堂,愿景：让技术不再难学
 * 优点：实现简单，没有多线程同步问题
 * 缺点：不管有没使用，instance对象一直占着这段内存
 * 或者说：
 * 优点：简单易读，线程安全
 * 缺点：可能造成内存浪费(单例的数量大到不可控)
 * @Description 单例设计 饿汉方式
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public class SingletonHungry {

    private static SingletonHungry instance = new SingletonHungry();
    //private static final SingletonHungry instance = new SingletonHungry(); //别的写法

    private SingletonHungry(){}

    public static SingletonHungry getInstance(){
        return instance;
    }

    /**
     * 单例对象的方法
     */
    public void process(){
        System.out.println("方法调用成功");
    }


}
