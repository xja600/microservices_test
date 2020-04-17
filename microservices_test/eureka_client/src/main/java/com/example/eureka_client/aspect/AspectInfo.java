package com.example.eureka_client.aspect;

import com.example.eureka_client.config.AspectTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author MG01972
 * @date 2019-10-10 16:18
 */
public class AspectInfo {
    private static final Logger LOG = LoggerFactory.getLogger(AspectInfo.class);
    public void test(){
        LOG.info("-----------test()-------");
    }
}
