package com.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HystrixTestController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * http://localhost:8772/hystrix/getList
     * @return
     */
    @RequestMapping("/hystrix/getList")
    @ResponseBody
    public List<String> getList(){
        long start = System.currentTimeMillis();
        try{
            long sleepTime = (long)(Math.random()*3000);
            Thread.sleep(sleepTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        list.add("author:xja");
        list.add("serverPort:"+serverPort);
        long end = System.currentTimeMillis();
        System.out.println("-------响应时间："+(end-start));
        return list;
    }

}
