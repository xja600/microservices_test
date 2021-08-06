package com.spring.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.dao.entity.CodeLibrary;
import com.spring.dao.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
  * 参考文章：https://www.cnblogs.com/wuyoucao/p/10941792.html
  * 有两种方法来进行缓存操作，一种是在方法上添加缓存注解实现各种操作，
  * 一种是手动控制(手动控制就相当于 mybatis 的手写 sql 语句，需要调用redisTemplate中的各种方法来进行缓存查询，缓存更新，缓存删除等操作。)
  * @CacheConfig: 类级别缓存，设置缓存 key 前缀之类的
  * @Cacheable: 触发缓存入口
  * @CacheEvict: 触发移除缓存
  * @CachePut: 更新缓存
  * @Caching: 组合缓存
  *  @author MG01972
  * @date 2019-10-08 16:22:43
  *
  */
@Repository
@CacheConfig(cacheNames = "userInfo")
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 文章连接：https://www.cnblogs.com/fashflying/p/6908028.html  介绍@Cacheable 等标签的用法
     *
     * 有的时候我们可能并不希望缓存一个方法所有的返回结果。通过condition属性可以实现这一功能。condition属性默认为空，表示将缓存所有的调用情形。其值是通过SpringEL表达式来指定的，
     * 当为true时表示进行缓存处理；当为false时表示不进行缓存处理，即每次调用该方法时该方法都会执行一次。如下示例表示只有当user的id为偶数时才会进行缓存。
     * {"userInfo"} : 定义
     * "#userInfo.userid" ：@Param("userInfo") 定义的，以及实体类对应的字段名称userid
     * condition = "#userInfo.status=='2'" : 同理
     * @param userInfo
     * @return
     */
    @Cacheable(value = {"userInfo"}, key = "#userInfo.userid", condition = "#userInfo.status=='2'")
    List<UserInfo> getUserInfo(@Param("userInfo") UserInfo userInfo);

}

