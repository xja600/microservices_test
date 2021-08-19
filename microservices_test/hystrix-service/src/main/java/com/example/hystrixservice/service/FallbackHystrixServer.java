package com.example.hystrixservice.service;

import com.example.hystrixservice.feign.OpenFeignServer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * https://blog.csdn.net/weixin_45842529/article/details/108805050
 * 配置服务降级类
 */
@Component
public class FallbackHystrixServer implements OpenFeignServer {
   /* @Override
    public String getId(Integer id) {
        return "getId 出错"+id;
    }

    @Override
    public String getTimeout() {
        return "getTimeout 出错";
    }*/

    @Override
    public List<String> getListFegin() {
        List<String> list = new ArrayList<String>();
        list.add("调用 [message-service] 服务异常，请稍后重试");
        return list;
    }

}

