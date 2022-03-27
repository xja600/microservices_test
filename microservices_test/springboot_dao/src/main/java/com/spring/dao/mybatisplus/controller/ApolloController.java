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

 注意：
 使用该方式不支持增加环境，只有通过分布式部署才可以新增环境
 使用该方式端口号不能修改，其他电脑无法使用配置中心
 使用自建项目使用配置中心，这里创建Spring Boot项目，在resources下创建META-INF目录，创建app.properties文件，配置app.id=** 和 apollo.meta=http://localhost:8080,更为具体的使用方式详见：Apollo java客户端使用指南
 通过./demo.sh stop停止服务 apolloconfigdb_pro
 ————————————————
 版权声明：本文为CSDN博主「笙箫123」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 原文链接：https://blog.csdn.net/q15102780705/article/details/102255192
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
