package com.spring.dao.springboot_dao.mybatisplus;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.dao.mybatisplus.controller.ApolloController;
import com.spring.dao.mybatisplus.entity.UserInfoPlus;
import com.spring.dao.mybatisplus.mapper.UserInfoPlusMapper;
import com.spring.dao.mybatisplus.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @RunWith(SpringJUnit4ClassRunner.class)、@SpringBootTest 两个注解才能在测试类查询数据库
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@SpringBootTest(classes = SpringbootDaoApplication.class).
//@MapperScan({"com.spring.dao.mapper","com.spring.dao.mybatisplus.mapper",})
@Slf4j
public class ApolloTest {

    @Autowired
    private ApolloController apolloController;

    @Test
    public void getMyName(){
        log.info("----getMyName()----");
        String name = apolloController.getMyName();
        log.info("----getMyName()---name[{}]-",name);
    }

}
