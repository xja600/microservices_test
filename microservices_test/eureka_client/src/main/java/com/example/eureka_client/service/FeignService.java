package com.example.eureka_client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("testFeignService")//是helloserver中的服务注册名称，不区分大小写
public interface FeignService {

    @RequestMapping("testFeignService")
    String testFeign();
}
