package com.spring.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.dao.entity.CodeLibrary;
import org.apache.ibatis.annotations.Param;
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
@CacheConfig(cacheNames = "CodeLibrary")
public interface CodeLibraryMapper extends BaseMapper<CodeLibrary> {
//    String getcode(@Param("itemNo") String itemNo);

//     @Cacheable(key ="#p0")
//     List<CodeLibrary> getCodeByCodeNo(@Param("codeNo") String codeNo);
//     @Cacheable(key ="#p0+#p1")
//     CodeLibrary getCodeByCodeNoAndItemNo(@Param("codeNo") String codeNo, @Param("itemNo") String itemNo);
//
//     @Cacheable(key ="'phase'+#p0+#p1")
//     List<PhaseNoVo> getPhaseList(@Param("codeNo") String codeNo, @Param("itemNo") String itemNo);

//    @Cacheable(key ="'name'+#p0+#p1")
    @Cacheable(value="myCache",key="'userName'")
    String getCodeNameByCodeNoAndItemNo(@Param("codeNo") String codeNo, @Param("itemNo") String itemNo);

//    @Select("select * from CODE_LIBRARY where Attribute1=#{attribute1}")
//    List<CodeLibrary> listByAttribute1(String attribute1);

     //@Cacheable(value=“nameCache”)，这个注释的意思是，当调用这个方法的时候，会从一个名叫 nameCache 的缓存(缓存本质是一个map)中查询key为name的值，
     // 如果不存在，则执行实际的方法（即查询数据库等服务逻辑），并将执行的结果存入缓存中，否则返回缓存中的对象。这里的缓存中的 key 就是参数 name，value
     // 就是 返回的User 对象
     @Cacheable(value="codeLibraryCache1",key="'abc'")
     List<CodeLibrary> getCodeNameByCodeNo(@Param("codeNo") String codeNo);

    @CacheEvict(value = "codeLibraryCache1",allEntries = true,beforeInvocation = true)
    public void removeFromCache();
}
