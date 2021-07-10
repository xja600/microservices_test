package com.example.eureka_client.xdclass.designpattern.abstractfactory.test;

import com.example.eureka_client.xdclass.designpattern.abstractfactory.factory.FactoryProducer;
import com.example.eureka_client.xdclass.designpattern.abstractfactory.factory.OrderFactory;

public class Test {

    public static void main(String[] args) {


        //简单工厂
        //PayFactory pay = SimplePayFactory.createPay("WECHAT_PAY");
        //PayFactory pay = SimplePayFactory.createPay("ALI_PAY");
        //pay.unifiedorder();


//        PayFactory aliPayFactory = new AliPayFactory();
//        PayFactory aliPay = aliPayFactory.getPay();
//        aliPay.unifiedorder();
//
//
//        PayFactory wechatPayFactory = new WechatPayFactory();
//        PayFactory wechatPay = wechatPayFactory.getPay();
//        wechatPay.unifiedorder();


        OrderFactory orderFactory = FactoryProducer.getFactory("ALI");//只要传类型即可

        orderFactory.createPay().unifiedorder();

        orderFactory.createRefund().refund();

    }
}
