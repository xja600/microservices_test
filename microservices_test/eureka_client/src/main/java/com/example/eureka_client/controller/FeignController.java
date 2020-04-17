package com.example.eureka_client.controller;

import com.example.eureka_client.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FeignController {
    @Autowired
    FeignService feignService;

    @RequestMapping(value = "/testFeignController", method = RequestMethod.GET)
    public String hello(){
        System.out.println("---------------feignController start--------------");
        return feignService.testFeign();

    }
}
