package com.spring.dao.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.dao.mybatisplus.entity.UserInfoPlus;
import com.spring.dao.mybatisplus.mapper.UserInfoPlusMapper;
import com.spring.dao.mybatisplus.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoPlusMapper userInfoPlusMapper;

    @Override
    public List<UserInfoPlus> getUserInfoList() {
        return userInfoPlusMapper.selectList(new QueryWrapper<UserInfoPlus>());
    }
    @Override
    public UserInfoPlus selectById(String userId) {
        return userInfoPlusMapper.selectById(userId);
    }
    @Override
    public List<UserInfoPlus> getUserListOwn(UserInfoPlus userInfoPlus) {
        return userInfoPlusMapper.selectList(new QueryWrapper<UserInfoPlus>());
    }
}
