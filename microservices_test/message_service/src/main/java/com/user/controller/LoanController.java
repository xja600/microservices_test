package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xinjunan 22
 * @date 2019/6/30 11:28
 * @Description:
 */

@Controller
public class LoanController {

    /**
     * 请求地址：http://localhost:8772/api/v1/loan/sendmessage1?message=测试zuul异常情况走这个服务
     * @param message
     * @return
     */
    @RequestMapping("/api/v1/loan/sendmessage1")
    @ResponseBody
    public String sendMessage(@RequestParam(value = "message") String message){
        System.out.println("=================发送放款短信1=================");
//        return "hello world";
        return message;
    }
    @RequestMapping("/api/v1/loan/sendmessage2")
    public void sendMessage(){
        System.out.println("=================发送放款短信2=================");
//        return "hello world";
    }
}
