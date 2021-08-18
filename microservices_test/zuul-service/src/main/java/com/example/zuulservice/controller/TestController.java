package com.example.zuulservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * #参考文章：https://www.cnblogs.com/q149072205/p/14081185.html
 * 测试zuul
 * zuul网关其底层使用ribbon来实现请求的路由，并内置Hystrix，可选择性提供网关fallback逻辑。使用zuul的时候，
 * 并不推荐使用Feign作为application client端的开发实现。毕竟Feign技术是对ribbon的再封装，
 * 使用Feign本身会提高通讯消耗，降低通讯效率，只在服务相互调用的时候使用Feign来简化代码开发就够了。而且商业开发中，使用Ribbon+RestTemplate来开发的比例更高。
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
