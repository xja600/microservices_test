package com.example.eureka_client.xdclass.jdk.jdk8.base64;

import com.example.eureka_client.xdclass.jdk.jdk8.interfac.Animal;
import com.example.eureka_client.xdclass.jdk.jdk8.interfac.Dog;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Main {
    public static void main(String[] args) {
        try {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            BASE64Decoder base64Decoder = new BASE64Decoder();

            //编码
            String str = "测试编码解码";
            byte[] byteStr = str.getBytes("utf-8");
            String encoderStr = base64Encoder.encode(byteStr);
            System.out.println("编码："+encoderStr);

            //解码
            System.out.println("解码："+new String(base64Decoder.decodeBuffer(encoderStr),"UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
