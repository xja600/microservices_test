package com.example.eureka_client.service.userinfo.impl;

import com.example.eureka_client.service.redis.util.RedisUtil;
import com.example.eureka_client.service.userinfo.IUserInfoService;
import com.spring.dao.entity.UserInfo;
import com.spring.dao.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<UserInfo> getUserInfo(String userId){

        UserInfo userInfo = new UserInfo();
        userInfo.setUserid(userId);
        // 从redis缓存中提取数据
        //List<UserInfo> userInfoList = (List<UserInfo>) redisTemplate.opsForValue().get("userInfoList_" + userId);
        List<UserInfo> userInfoList = (List<UserInfo>) redisUtil.get("userInfoList_" + userId);
        log.info("========userInfoList={}==============",userInfoList);
        // 如果缓存中没有，则从数据库中查询并放入缓存中
        if(CollectionUtils.isEmpty(userInfoList)){
            userInfoList = userInfoMapper.getUserInfo(userInfo);
            redisTemplate.opsForValue().set("userInfoList_" + userId, userInfoList);
            log.info("========userInfoList为空，查数据库的用户信息放到缓存==============userInfoList_" + userId);
        }

        return userInfoList;
    }


}
