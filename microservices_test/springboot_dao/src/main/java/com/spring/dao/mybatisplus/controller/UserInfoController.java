package com.spring.dao.mybatisplus.controller;


import com.alibaba.fastjson.JSON;
import com.spring.dao.mybatisplus.entity.UserInfoPlus;
import com.spring.dao.mybatisplus.service.UserInfoService;
import com.spring.dao.mybatisplus.service.impl.UserInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * mybatisPlus-获取数据
 */
@RestController
@RequestMapping("/api/controller/dao")
@Slf4j
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    /**
     * 查询全部的数据
     * http://localhost:8080/api/controller/dao/getUserInfoList
     * @param userId
     * @return
     */
    @RequestMapping("getUserInfoList")
    public String getUserInfoList(String userId){
        log.info("---/api/controller/dao,getUserInfoList()====");
        List<UserInfoPlus> userInfoPlusList = userInfoService.getUserInfoList();
        log.info("---/api/controller/dao,userInfoPlusList()[{}]====",userInfoPlusList);
       return JSON.toJSONString(userInfoPlusList);
    }
    /**
     * 根据 userId
     * http://localhost:8080/api/controller/dao/selectById?userId=test75
     * @param userId
     * @return
     */
    @RequestMapping("selectById")
    public String selectById(String userId){
        log.info("---/api/controller/dao,getUserInfoList()====userId[{}]",userId);
        UserInfoPlus userInfoPlus = userInfoService.selectById(userId);
        log.info("---/api/controller/dao,userInfoPlusList()[{}]====",userInfoPlus);
        return JSON.toJSONString(userInfoPlus);
    }
}
