package com.example.eureka_client.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * @author MG01972
 * @date 2019-09-26 15:49
 */
@Service
public class PushDataToBI implements ApplicationListener<ContextRefreshedEvent> {

//    @Autowired
//    SLAssetInfoServic;
private static final Logger logger = LoggerFactory.getLogger(PushDataToBI.class);
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            logger.info("---------------------PushDataToBI---------------------------");
//            assetInfoService2.pushDataToBIByStatus("02");
            logger.info("------------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
