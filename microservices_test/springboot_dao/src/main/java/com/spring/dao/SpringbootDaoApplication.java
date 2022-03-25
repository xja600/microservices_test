package com.spring.dao;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
//@MapperScan({"com.spring.dao.*"})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@MapperScan("com")
//@ComponentScan(basePackages = { "com.spring.dao","com.slabs"})
@MapperScan({"com.spring.dao.mapper","com.slabs.pushdata.dao","com.spring.dao.mybatisplus.mapper",})
//开启swagger api
@EnableOpenApi
@EnableApolloConfig
public class SpringbootDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDaoApplication.class, args);
    }
    //强制改端口
 /*   @Bean
    public TomcatServletWebServerFactory servletContainer(){
        return new TomcatServletWebServerFactory(8023) ;
    }*/

}
