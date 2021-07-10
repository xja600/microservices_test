package com.example.eureka_client.xdclass.designpattern.abstractfactory.factory;

public interface OrderFactory {



    PayFactory createPay();


    RefundFactory createRefund();


}
