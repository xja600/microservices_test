package com.spring.dao.mybatisplus.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 安装apollo教程：
 --apollo-service
 http://www.cppcns.com/ruanjian/java/268257.html
 https://blog.csdn.net/weixin_42073629/article/details/106346337
 --apollo-client
 https://blog.csdn.net/weixin_35158450/article/details/114616270
 https://www.cnblogs.com/huanchupkblog/p/10509427.html
 本地启动：
 存放目录：E:\software\apollo\apollo-build-scripts-master
 右键-->git base here-->启动命令：./demo.sh start
 启动成功之后，登录地址：
 http://127.0.0.1:8070
 默认 用户名密码是 apollo admin
 */
@RestController
@RequestMapping("/api/controller/apollo")
@Slf4j
public class ApolloController {
    @Value("${server.port}")
    private String port;

    @Value("${test.username}")
    private String myname;

    /**
     * http://localhost:8086/api/controller/apollo/getUrl
     * @return
     */
    @GetMapping("getUrl")
    public String getUrl(){
        log.info("-----------getUrl()-----------port={}",port);
        return port;
    }
    /**
     * http://localhost:8086/api/controller/apollo/getMyName
     * @return
     */
    @GetMapping("getMyName")
    public String getMyName(){
        log.info("-----------getMyName()-----------myname={}",myname);
        return myname;
    }
}
