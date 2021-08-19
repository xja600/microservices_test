package com.example.hystrixservice.feign;

import com.example.hystrixservice.service.FallbackHystrixServer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 通过 @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的 {xxx} 占位符可以通过
 * @PathVariable("xxx") 绑定到操作方法的入参中。
 * 一般与@RequestMapping(method = RequestMethod.GET)一起使用
 */
@Component
@FeignClient(name = "message-service",fallback = FallbackHystrixServer.class)
public interface OpenFeignServer {
   /* @GetMapping("/hystrix/getId/{id}")
    public String getId(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/timeout")
    public String getTimeout() ;*/

    //请求映射路径 /serviceA/getList 同 A 服务的映射路径
    @RequestMapping(value="/hystrix/getList")
    public List<String> getListFegin();
}
