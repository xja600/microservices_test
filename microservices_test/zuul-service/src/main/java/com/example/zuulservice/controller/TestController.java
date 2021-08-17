package com.example.zuulservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * #参考文章：https://www.cnblogs.com/q149072205/p/14081185.html
 * 测试zuul
 */
@RestController
public class TestController {

    /**
     * 请求地址：http://localhost:8774/test/page1
     */
    //读取配置中心的参数
    @Value("${sysconfig.isDebug}")
    private Boolean isDebug;

    @RequestMapping("test/page1")
    public String page1(){
        return "zuul page1. current time:"+(new Date()).toString();
    }

    /**
     * 请求地址：http://localhost:8774/test/page2
     */
    @RequestMapping("test/page2")
    public String page2(){return "zuul page2.sysconfig.isDebug="+isDebug.toString();}
}
