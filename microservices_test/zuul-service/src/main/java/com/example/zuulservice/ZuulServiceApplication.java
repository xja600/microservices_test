package com.example.zuulservice;

import com.example.zuulservice.ribbon.AvoidScan;
//import com.example.zuulservice.ribbon.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableDiscoveryClient

/* 这段代码是要得，勿删除，配置ribbon负载均衡用
@RibbonClient(name = "message-service", configuration = RibbonConfiguration.class)//表示针对message-service服务使用的负责策略是经过RibbonConfiguration配置类的。
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {AvoidScan.class})})//表示让工程在启动的时候，不让Spring扫描被@AvoidScan注解标记的类，
*/

public class ZuulServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServiceApplication.class, args);
    }

}
