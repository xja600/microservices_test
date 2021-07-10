package com.example.eureka_client.xdclass.designpattern.factory.test;


import com.example.eureka_client.xdclass.designpattern.factory.Pay;
import com.example.eureka_client.xdclass.designpattern.factory.method.AliPayFactory;
import com.example.eureka_client.xdclass.designpattern.factory.method.PayFactory;
import com.example.eureka_client.xdclass.designpattern.factory.method.WechatPayFactory;

public class Test {

    public static void main(String[] args) {


        //简单工厂
        //Pay pay = SimplePayFactory.createPay("WECHAT_PAY");
        //Pay pay = SimplePayFactory.createPay("ALI_PAY");
        //pay.unifiedorder();


        PayFactory aliPayFactory = new AliPayFactory();
        Pay aliPay = aliPayFactory.getPay();
        aliPay.unifiedorder();


        PayFactory wechatPayFactory = new WechatPayFactory();
        Pay wechatPay = wechatPayFactory.getPay();
        wechatPay.unifiedorder();



    }
}
