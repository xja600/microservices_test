package com.example.eureka_client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xinjunan
 * @date 2019/6/30 11:15
 * @Description: test
 */
//MESSAGE-SERVICE 是被调用方(服务方的)名称
@FeignClient(name="MESSAGE-SERVICE" ,url = "")
public interface LoanMessageFeign {

    // /api/v1/sendmessage ：被调用方(服务方)路由
    @RequestMapping("/api/v1/loan/sendmessage1")
    String sendMessage(@RequestParam(value = "message") String message);
}
