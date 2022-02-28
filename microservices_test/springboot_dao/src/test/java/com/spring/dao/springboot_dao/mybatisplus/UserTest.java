package com.spring.dao.springboot_dao.mybatisplus;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.dao.mybatisplus.entity.UserInfoPlus;
import com.spring.dao.mybatisplus.mapper.UserInfoPlusMapper;
import com.spring.dao.mybatisplus.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
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
public class UserTest {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoPlusMapper userInfoPlusMapper;

    @Test
    public void getUserInfoById(){
        log.info("----getUserInfoById()----");
        UserInfoPlus userInfoPlus = userInfoService.selectById("test75");
        log.info("----getUserInfoById()---userInfoPlus[{}]-",userInfoPlus);
    }


    /**
     * 批量查找
     */
    @Test
    public void testSelectBatchIds(){
        List<UserInfoPlus> userInfoPlusList = userInfoPlusMapper.selectBatchIds(Arrays.asList("test75","test73"));
        log.info("----testSelectBatchIds()---userInfoPlusList[{}]-",userInfoPlusList);
    }

    /**
     * 选择1条
     */
    @Test
    public void testSelectOne(){

        UserInfoPlus userInfoPlus = userInfoPlusMapper.selectOne(new QueryWrapper<UserInfoPlus>().eq("USERID","pt14"));
        log.info("userInfoPlus: {}",userInfoPlus);
    }

    /**
     * 统计行数
     */
    @Test
    public void testSelectCount(){

        int size = userInfoPlusMapper.selectCount(null);
        log.info("size: {}",size);
    }

    /***
     * 查找全部数据
     */
    @Test
    public void testBannerList(){

        List<UserInfoPlus> list = userInfoService.getUserInfoList();
        log.info("轮播图列表:{}",list);

    }

    /***
     * 新增
     */
    @Test
    public void testAdd(){

        UserInfoPlus userInfoPlus = new UserInfoPlus();
        userInfoPlus.setUserid("testPlus");
        userInfoPlus.setUsername("测试mybatisplus");
        userInfoPlus.setAttribute("123");
        userInfoPlusMapper.insert(userInfoPlus);

        log.info("轮播图:{}",userInfoPlusMapper);
    }

    @Test
    public void testDeleteId(){

        int rows = userInfoPlusMapper.deleteById("testPlus");
        log.info("rows:{}",rows);

    }

    /**
     * 通过 userid 和 username 为条件删除
     */
    @Test
    public void testDeleteByMap(){

        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("ATTRIBUTE","123");
        columnMap.put("USERNAME","测试mybatisplus");

        int rows = userInfoPlusMapper.deleteByMap(columnMap);
        log.info("rows:{}",rows);

    }

    /**
     * 更新
     */
    @Test
    public void testUpdate(){

        UserInfoPlus userInfoPlus = new UserInfoPlus();
        userInfoPlus.setUsername("测试mybatisplus111");
        int rows = userInfoPlusMapper.update(userInfoPlus,new QueryWrapper<UserInfoPlus>().eq("USERID","testPlus"));
        log.info("rows:{}",rows);
    }

    /**
     * 更新 UPDATE USER_INFO SET ATTRIBUTE=? WHERE USERID = ?
     */
    @Test
    public void testUpdateWrapper(){

        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("ATTRIBUTE","123456");
        updateWrapper.eq("USERID","testPlus");
        int rows = userInfoPlusMapper.update(null,updateWrapper);
        log.info("rows:{}",rows);
    }

    /**
     * * eq 等于
     * * ne 不等于
     * * gt 大于
     * * ge 大于等于
     * * lt 小于
     * * le 小于等于
     * * or 拼接or
     * * between 两个值中间
     * * notBetween 不在两个值中间
     */
    @Test
    public void testQueryWrapper1(){
        //SELECT * FROM USER_INFO WHERE USERID = ? OR ATTRIBUTE <> ?
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("USERID","testPlus");
        queryWrapper.or();
        queryWrapper.ne("ATTRIBUTE","123456");

        userInfoPlusMapper.selectList(queryWrapper);
    }

    /**
     * * like 模糊匹配
     * * notLike 不像
     * * likeLeft 左匹配
     * * likeRight 右边匹配
     * * isNull 字段为空
     * * in  in查询
     * * groupBy 分组
     * * orderByAsc 升序
     * * orderByEdsc 降序
     * * having having查询
     */
    @Test
    public void testQueryWrapper2(){

        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.like("url","bbb");
//        queryWrapper.notLike("img","cccc");
        //SELECT id,img,url,weight AS weightAAA FROM banner WHERE (url LIKE ? AND img NOT LIKE ?)

        //queryWrapper.likeLeft("url","bbb");
        //queryWrapper.likeRight("img","cccc");
        //select t.*, t.rowid from USER_INFO t where t.attribute1 is null and t.attribute7 in( '0','3') ORDER BY USERID DESC ;
        queryWrapper.isNull("ATTRIBUTE1");
        queryWrapper.in("ATTRIBUTE7",Arrays.asList("0","3"));
        queryWrapper.orderByDesc("USERID");

        //SELECT id,img,url,weight AS weightAAA FROM banner WHERE (img IS NULL AND url IN (?,?)) ORDER BY id DESC
        userInfoPlusMapper.selectList(queryWrapper);
    }

    /**
     * 测试分页功能
     */
    @Test
    public void  testPage(){

//        QueryWrapper<BannerDO> queryWrapper = new QueryWrapper();
//        queryWrapper.eq("weight",4);

        //第一页，每页3条, 如果是第一页则直接一个问号，获取条数
        Page<UserInfoPlus> page  = new Page<>(1,10);

        IPage<UserInfoPlus> iPage =  userInfoPlusMapper.selectPage(page,null);

        log.info("总条数:{}",iPage.getTotal());

        log.info("总页数:{}",iPage.getPages());

        log.info("数据：{}",iPage.getRecords());
    }


    /**MybatisPlusInterceptor
     * 自定义sql
     */
    @Test
    public void testGetUserListOwn(){

        UserInfoPlus userInfoPlus = new UserInfoPlus();
        userInfoPlus.setUserid("test37");
        List<UserInfoPlus> list = userInfoPlusMapper.getUserListOwn(userInfoPlus);
        log.info("getUserListOwn:{}",list);
    }

    /**
     * 测试指定字段查询
     */
    @Test
    public void  testSelect(){

        QueryWrapper<UserInfoPlus> queryWrapper = new QueryWrapper();

        //第一页，每页3条, 如果是第一页则直接一个问号，获取条数
        Page<UserInfoPlus> page  = new Page<>(2,10);

        IPage<UserInfoPlus> iPage =  userInfoPlusMapper.selectPage(page, queryWrapper.select("USERID","ATTRIBUTE","USERNAME"));

        log.info("总条数:{}",iPage.getTotal());

        log.info("总页数:{}",iPage.getPages());

        log.info("数据：{}",iPage.getRecords());
    }


    /**
     * 乐观锁测试
     * 配置文件：MybatisConfig.java
     */
    @Test
    public void testOptimi(){

        //先根据ID找记录，得到id 和 version
        //比如更新前的version为1，则 他获取这条数据的时候就是1，然后更新完之后为2，自动加1
        //如果中途被别的线程更新为2，则他会回滚，不能更新,这些逻辑 mybatisplus自动带有
        //UPDATE USER_INFO SET version=?, USERNAME=?, ATTRIBUTE=? WHERE USERID=? AND version='1'
        UserInfoPlus userInfoPlus = new UserInfoPlus();
        userInfoPlus.setVersion(1);
        userInfoPlus.setUserid("testPlus");
        userInfoPlus.setUsername("测试mybatisplus-测试乐观锁2");
        userInfoPlus.setAttribute("123");
        userInfoPlusMapper.updateById(userInfoPlus);


    }

    /**
     * 测试删除数据的标识 deleted
     * 逻辑删除
     * UPDATE USER_INFO SET deleted=1 WHERE USERID=? AND deleted=0
     * 查询的时候插件也自动会加上deleted的标识
     */
    @Test
    public void testDeleteId2(){

        int rows = userInfoPlusMapper.deleteById("testPlus");
        log.info("rows:{}",rows);

    }
}
