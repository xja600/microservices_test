package com.spring.dao.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * 参考文章：https://www.cnblogs.com/wuyoucao/p/10941792.html
 * @EnableCaching注解是spring framework中的注解驱动的缓存管理功能。自spring版本3.1起加入了该注解。如果你使用了这个注解，那么你就不需要在XML文件中配置cache manager了，等价于 <cache:annotation-driven/> 。能够在服务类方法上标注@Cacheable
 *
 * @Author: xinjunan
 * @Description:
 * @Date: Created in  2019/09/23
 */

@Configuration
@EnableCaching //开启缓存
public class RedisConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;

    /**
     * 设置缓存管理器，这里可以配置默认过期时间等
     *
     * @param connectionFactory 连接池
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        return RedisCacheManager
                .builder(factory)
                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(24*60*60)))
                .transactionAware()
                .build();

    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();


        template.setConnectionFactory(factory);

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        RedisSerializer jacksonSeial = new FastJsonRedisSerializer<>(Object.class);
        // 值采用json序列化
        template.setValueSerializer(jacksonSeial);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());

        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jacksonSeial);
        template.afterPropertiesSet();

        return template;

    }

    /**
     * 对hash类型的数据操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    /**
     * 对redis字符串类型数据操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    /**
     * 对链表类型的数据操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    /**
     * 对无序集合类型的数据操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    /**
     * 对有序集合类型的数据操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }


    //使用jedis连接池建立jedis连接工厂
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory() {
//        logger.info("jedisConnectionFactory:初始化了");
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxIdle(maxIdle);
//        config.setMinIdle(minIdle);
//        config.setMaxWaitMillis(maxWaitMillis);
//        config.setMaxTotal(maxActive);
//        //链接耗尽时是否阻塞，默认true
//        config.setBlockWhenExhausted(true);
//        //是否启用pool的jmx管理功能，默认true
//        config.setJmxEnabled(true);
//        JedisConnectionFactory factory = new JedisConnectionFactory();
//        factory.setPoolConfig(config);
//        factory.setHostName(host);
//        factory.setPort(port);
//        factory.setPassword(password);
//        factory.setDatabase(database);
//        factory.setTimeout(timeout);
//        return factory;
//    }
}
