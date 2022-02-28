package com.spring.dao.mybatisplus.service;

import com.spring.dao.mybatisplus.entity.UserInfoPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoService {

    List<UserInfoPlus> getUserInfoList();
    UserInfoPlus selectById(String userId) ;
    List<UserInfoPlus> getUserListOwn(UserInfoPlus userInfoPlus);
}
