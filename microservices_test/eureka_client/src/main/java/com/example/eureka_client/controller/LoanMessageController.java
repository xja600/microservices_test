package com.example.eureka_client.controller;

import com.example.eureka_client.feign.LoanMessageFeign;
import com.example.eureka_client.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoanMessageController {
    @Autowired
    LoanMessageFeign loanMessageFeign;

    // postman请求地址 http://localhost:8771/api/controller/loan/sendmessage
    //test-20190923
    @RequestMapping(value = "/api/controller/loan/sendmessage", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        System.out.println("---------------sendMessageController start--------------");
        return loanMessageFeign.sendMessage("===========测试feign===========");
    }
}
