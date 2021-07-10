package com.example.eureka_client.xdclass.designpattern.factory.method;


import com.example.eureka_client.xdclass.designpattern.factory.AliPay;
import com.example.eureka_client.xdclass.designpattern.factory.Pay;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public class AliPayFactory implements PayFactory {


    @Override
    public Pay getPay() {
        return new AliPay();
    }
}
