package com.spring.dao.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan(basePackages = {"com.spring.dao.mapper"})
public class MybatisConfig {

    /** 作用：分頁的時候传第几页和每页多少条数据
    * 在进行查询的的时候使用的PageHelper进行了拦截： https://blog.csdn.net/lingyejun/article/details/122022897
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
    */

  @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        //分页插件,这个插件导致在分页查询的时候会报错的
        //interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        //乐观锁插件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());

        return interceptor;
    }

}
