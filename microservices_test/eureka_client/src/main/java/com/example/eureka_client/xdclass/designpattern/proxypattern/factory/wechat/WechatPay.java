package com.example.eureka_client.xdclass.designpattern.proxypattern.factory.wechat;


import com.example.eureka_client.xdclass.designpattern.proxypattern.factory.PayFactory;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public class WechatPay implements PayFactory {

    @Override
    public void unifiedorder() {

        System.out.println("微信支付支付 统一下单接口");
    }
}
