package com.example.eureka_client.service;

public interface RedisService {

    /**
     * set存数据
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, String value);

    /**
     * get获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * setHash存数据
     * @param key
     * @param value
     * @return
     */
    boolean setHash(String key,String hashKey, String value);


    /**
     * getHash获取数据
     * @param key
     * @return
     */
    Object getHash(String key, String hashKey);


    /**
     * 列表存数据(字符串)
     * @param key
     * @param value
     * @return
     */
    boolean setList_string(String key,Object value);

    /**
     * 列表获取数据(字符串)
     * @param key
     * @param value
     * @return
     */
    Object getList_string(String key,long start, long end);


    /**
     * 设置有效天数
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 移除数据
     * @param key
     * @return
     */
    boolean remove(String key);

}