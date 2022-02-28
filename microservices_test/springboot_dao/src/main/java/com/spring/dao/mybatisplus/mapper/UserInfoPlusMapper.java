package com.spring.dao.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.dao.mybatisplus.entity.UserInfoPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoPlusMapper extends BaseMapper<UserInfoPlus> {

    /**
     * mybatisplus自定义sql
     * @param userInfoPlus
     * @return
     */
    List<UserInfoPlus> getUserListOwn(@Param("userInfoPlus")UserInfoPlus userInfoPlus);
}
