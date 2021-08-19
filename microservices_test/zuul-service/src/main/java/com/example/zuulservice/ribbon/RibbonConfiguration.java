package com.example.zuulservice.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * Ribbon负载策略配置类，IClientConfig是针对客户端的管理配置器，配合@RibbonClient注解使用
 * 由于系统集成有了feign
 * eign其实不是做负载均衡的,负载均衡是ribbon的功能,feign只是集成了ribbon而已,但是负载均衡的功能还是feign内置的ribbon再做,而不是feign。
 * feign的作用的替代RestTemplate,性能比较低，但是可以使代码可读性很强。
 *
 * https://bbs.csdn.net/topics/392516302?list=8518838
 * ribbon的负载均衡策略，默认的常见有随机规则,轮询规则,权重规则
 * 随机不用说，轮询也不用说，权重意思是,请求时间越久的server,其被分配给客户端使用的可能性就越低。
 * ribbon也可以自定义策略。具体方法包括：
 * 方法1.实现IRule接口
 * 方法2.集成AbstractLoadBalancerRule 、PredicateBasedRule。
 *
 * 只要在配置中自动注入自定义的策略bean就可以
 * @Bean
 *   public IRule ribbonRule() {
 *     // 负载均衡规则，改为随机
 *     return new RandomRule();
 *   }
 */
//@Configuration
@AvoidScan
public class RibbonConfiguration {

    @Autowired
    private IClientConfig config;

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RandomRule();
    }
}
