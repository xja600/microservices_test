package com.example.eureka_client.xdclass.designpattern.proxypattern.factory.ali;


import com.example.eureka_client.xdclass.designpattern.proxypattern.factory.OrderFactory;
import com.example.eureka_client.xdclass.designpattern.proxypattern.factory.PayFactory;
import com.example.eureka_client.xdclass.designpattern.proxypattern.factory.RefundFactory;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public class AliOrderFactory implements OrderFactory {

    @Override
    public PayFactory createPay() {
        return new AliPay();
    }

    @Override
    public RefundFactory createRefund() {
        return new AliRefund();
    }
}
