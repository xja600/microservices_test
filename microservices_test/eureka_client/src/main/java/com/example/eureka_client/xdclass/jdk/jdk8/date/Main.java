package com.example.eureka_client.xdclass.jdk.jdk8.date;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            LocalDate localDate = LocalDate.now();
            System.out.println("今天日期："+localDate);

            //获取年月日，周
            System.out.println("年："+localDate.getYear());
            System.out.println("月："+localDate.getMonth());
            System.out.println("月(数字)："+localDate.getMonthValue());
            System.out.println("现在是几号："+localDate.getDayOfMonth());
            System.out.println("周几："+localDate.getDayOfWeek());

            //加减年份，加后返回的对象才是修改的，旧的依然是旧的
            LocalDate changeDate = localDate.plusYears(1);
            System.out.println("加后的年份："+changeDate.getYear());
            System.out.println("旧的哪年："+localDate.getYear());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
