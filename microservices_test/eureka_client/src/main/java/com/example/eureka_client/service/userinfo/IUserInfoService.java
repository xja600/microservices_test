package com.example.eureka_client.service.userinfo;

import com.spring.dao.entity.UserInfo;

import java.util.List;

public interface IUserInfoService {

    public List<UserInfo> getUserInfo(String userId);
}
