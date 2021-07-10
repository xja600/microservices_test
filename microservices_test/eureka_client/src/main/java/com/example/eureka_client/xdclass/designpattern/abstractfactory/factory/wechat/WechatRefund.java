package com.example.eureka_client.xdclass.designpattern.abstractfactory.factory.wechat;


import com.example.eureka_client.xdclass.designpattern.abstractfactory.factory.RefundFactory;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public class WechatRefund implements RefundFactory {
    @Override
    public void refund() {

        System.out.println("微信支付 退款");
    }
}
