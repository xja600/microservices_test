package com.example.eureka_client.controller;


import com.example.eureka_client.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RocketMqController {

    @Autowired
    private ProducerService producer;

    /*
    * postmane访问地址：http://localhost:8771/push?msg=hello
    * 启动命令 ：nohup sh broker -n localhost:9876 autoCreateTopicEnable=true &
    *
    * 报错 ： window  No route info of this topic, test1 --> rocketmq-client 版本改为 ：4.3.0 (https://blog.csdn.net/zzzgd_666/article/details/81481584)
    * cmd中执行命令开启服务：(https://www.cnblogs.com/gaoquanquan/p/10844320.html)
    * start namesrv
    * start mqbroker -n 127.0.0.1:9876
    * mq界面工具地址： http://localhost:12581/#/
    */
    @RequestMapping("/push")
    public String pushMsg(String msg) {

        System.out.println("-------------11----------------");
        return producer.send("test1", "push", msg);

    }
}
