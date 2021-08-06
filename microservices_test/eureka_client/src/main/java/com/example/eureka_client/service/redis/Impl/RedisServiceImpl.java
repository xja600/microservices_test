package com.example.eureka_client.service.redis.Impl;

import com.example.eureka_client.service.redis.RedisService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("redisService")
public class RedisServiceImpl implements RedisService {

    /**
     * 在这里execute()方法具体的底层没有去研究，只知道这样能实现对于redis数据的操作。
     * redis保存的数据会在内存和硬盘上存储，所以需要做序列化；这个里面使用的StringRedisSerializer来做序列化，不过这个方式的泛型指定的是String，只能传String进来。所以项目中采用json字符串做redis的交互。
     *
     * 作者：你想要怎样的未来
     * 链接：https://www.jianshu.com/p/19628db2e7ef
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    @Resource
    private RedisTemplate<String, ?> redisTemplate;

    @Override
    public boolean set(final String key, final String value) {

        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));

                return true;
            }
        });
        return result;
    }

    @Override
    public String get(final String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value = connection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
        return result;
    }

    @Override
    public boolean setHash(String key, String hashKey, String value) {
//        redisTemplate.opsForHash().put("user_01","userName","xja");
        redisTemplate.opsForHash().put(key,hashKey,value);
        return true;
    }

    @Override
    public Object getHash(String key,String hashKey) {

        return redisTemplate.opsForHash().get(key, hashKey);
    }

    @Override
    public boolean setList_string(String key, Object value) {

        List<String > listAdd = new ArrayList<>();

//        ListOperations<String, Object> list = redisTemplate.opsForList().rightPush(key,listAdd);
//        list.rightPush(key, value);
//         redisTemplate.opsForList().rightPush("list","aa").rightPush(key, value);

    /*    redisTemplate.opsForList().rightPush("list","w");
        list =  redisTemplate.opsForList().range("list",0,-1);
        System.out.println("通过rightPush(K key, V value)方法向最右边添加元素:" + list);*/
        return false;
    }

    @Override
    public Object getList_string(String key, long start, long end) {

        return redisTemplate.opsForList().range(key,start,end);
    }

    @Override
    public boolean expire(final String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public boolean remove(final String key) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.del(key.getBytes());
                return true;
            }
        });
        return result;
    }
}
