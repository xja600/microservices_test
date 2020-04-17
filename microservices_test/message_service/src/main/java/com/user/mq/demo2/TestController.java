package com.user.mq.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MG01972
 * @date 2019-12-31 15:44
 */
public class TestController {
    @Autowired
    private ProducerService producer;

    @RequestMapping("/push")
    public String pushMsg(String msg) {

        System.out.println("-------------1----------------");
        return producer.send("test1", "push", msg);

    }
}
