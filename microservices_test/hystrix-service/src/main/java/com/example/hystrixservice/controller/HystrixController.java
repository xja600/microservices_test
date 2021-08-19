package com.example.hystrixservice.controller;


import com.example.hystrixservice.feign.OpenFeignServer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 在使用feign接口进行调用的时候，如果程序出错会返回降级的返回信息，以确保出错我们的程序不会因为一个服务的出错进而造成服务的雪崩，导致整个微服务的其他功能也无法使用
 * 处理Hystrix请求
 */

@Controller
public class HystrixController {

    @Autowired
    private OpenFeignServer openFeignServer;
    @GetMapping("/getId/{id}")
    @HystrixCommand(fallbackMethod = "getIdFall",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value ="true"),//开启熔断机制
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String getId(@PathVariable("id") Integer id) {
        if (id<0){
            throw new RuntimeException();
        }
        //String returnStr = openFeignServer.getId(id);
        return "returnStr";
    }
    public String getIdFall(@PathVariable("id") Integer id) {
        return "id不能为负"+id;
    }


    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet=new HystrixMetricsStreamServlet();
        ServletRegistrationBean hystrixRegistrationBean = new ServletRegistrationBean<>(streamServlet);
        hystrixRegistrationBean.setLoadOnStartup(1);
        hystrixRegistrationBean.addUrlMappings("/hystrix.stream");
        hystrixRegistrationBean.setName("HystrixMetricsStreamServlet");
        return hystrixRegistrationBean;
    }


}

