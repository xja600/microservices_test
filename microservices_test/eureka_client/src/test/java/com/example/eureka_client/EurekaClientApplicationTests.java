package com.example.eureka_client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import com.slabs.pushdata.service.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaClientApplicationTests {

    @Autowired
//    SLAssetInfoService2 assetInfoService2;
    @Test
    public void contextLoads() {
        try{
//            assetInfoService2.pushDataToBIByStatus("02");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
