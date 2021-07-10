package com.example.eureka_client.xdclass.designpattern.proxypattern.bridge;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description  手机的实例化
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public class HWPhone extends Phone {

    public HWPhone(Color color){
        super.setColor(color);
    }

    @Override
    public void run() {
        color.useColor();
        System.out.println("华为手机");
    }
}
