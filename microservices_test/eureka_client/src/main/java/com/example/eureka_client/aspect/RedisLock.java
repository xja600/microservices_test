package com.example.eureka_client.aspect;

import com.example.eureka_client.exception.AsyncMethodLockException;
import com.example.eureka_client.util.DateUtil;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.net.InetAddress;
import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: XiongFeng
 * @Description:
 * @Date: Created in 18:25 2018/6/13
 */
public class RedisLock {
    private static final Logger LOG = LoggerFactory.getLogger(RedisLock.class);

    //纳秒和毫秒之间的转换率
    public static final long MILLI_NANO_TIME = 1000 * 1000L;

    public static final String LOCKED = "TRUE";

    public static final Random RANDOM = new Random();
    public String key;
    private String methodName;

    private ValueOperations valueOperations;
    private RedisTemplate redisTemplate;

    private boolean lock = true;

    /**
     *
     * @param purpose 锁前缀
     * @param key 锁定的ID等东西
     * @param redisTemplate
     */
    public RedisLock(String purpose, String key, RedisTemplate redisTemplate){
        this.key = purpose + "_" + key + "_lock";
        this.redisTemplate = redisTemplate;
        this.valueOperations = redisTemplate.opsForValue();
    }

    /**
     *
     * @param purpose 锁前缀
     * @param key 锁定的ID等东西
     * @param redisTemplate
     */
    public RedisLock(String purpose, String methodName, String preString, String key, RedisTemplate redisTemplate){
        StringJoiner keyStringJoiner = new StringJoiner(":");
        keyStringJoiner.add(purpose);
        keyStringJoiner.add(preString);
        keyStringJoiner.add(key);
        this.key = keyStringJoiner.toString();
        this.redisTemplate = redisTemplate;
        this.valueOperations = redisTemplate.opsForValue();
        this.methodName = methodName;
    }
    /**
     * 加锁
     * 使用方式为：
     * lock();
     * try{
     * 	  executeMethod();
     * }finally{
     * 	 unlock();
     * }
     * @param timeout timeout的时间范围内轮询锁
     * @param expireTime 设置锁超时时间
     * @return 成功 or 失败
     */
    public boolean lock(long timeout,long expireTime){
        try {
            AtomicInteger count = new AtomicInteger(1);
            while (timeout >= 0) {
                StringJoiner valueStringJoiner = new StringJoiner(" | ");
                valueStringJoiner.add(this.methodName);
                valueStringJoiner.add(InetAddress.getLocalHost().getHostAddress());
                valueStringJoiner.add(DateUtil.getToday("yyyy-MM-dd HH:mm:ss:SSS"));
                String lockValue = valueStringJoiner.toString();
                //锁不存在的话，设置锁并设置锁过期时间，即加锁
                if (this.valueOperations.setIfAbsent(key, lockValue, expireTime, TimeUnit.MILLISECONDS)) {
                    //锁的情况下锁过期后消失，不会造成永久阻塞
                    this.lock = true;
                    LOG.debug("加锁成功! lockName: {}, method: {}", this.key, this.methodName);
                    return this.lock;
                }
                LOG.debug("分布式锁,出现等待,正在第{}次尝试... lockName: {}, method: {}", count.getAndAdd(1), this.key, this.methodName);
                //短暂休眠，避免可能的活锁
                long sleepTime = RandomUtils.nextLong(10L, 30L);
                timeout = timeout - sleepTime;
                Thread.sleep(sleepTime);
            }
            LOG.debug("分布式锁，锁等待超时! lockName: {}, method: {}", this.key, this.methodName);
        } catch (Exception e) {
            throw new AsyncMethodLockException(String.format("locking error! 加锁出现异常！lockName: %s, method: %s", this.key, this.methodName), e);
        }
        return false;
    }

    public void unlock() {
        try {
            if(this.lock){
                this.lock = false;
                redisTemplate.delete(key);//直接删除
            }
        } catch (Throwable e) {

        }
    }
}
