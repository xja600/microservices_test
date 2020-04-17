package com.spring.dao.springboot_dao;

import com.spring.dao.entity.CodeLibrary;
import com.spring.dao.entity.UserInfo;
import com.spring.dao.mapper.CodeLibraryMapper;
import com.spring.dao.mapper.UserInfoMapper;
import com.spring.dao.test.CodeLibraryServiceImpl2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDaoApplicationTests {

    Logger logger = LoggerFactory.getLogger(SpringbootDaoApplicationTests.class);

    @Autowired
    CodeLibraryServiceImpl2 codeLibraryServiceImpl2;

//    @Autowired
//    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    CodeLibraryMapper codeLibraryMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
//    @Autowired
//    SLAssetInfoService2 assetInfoService2;

//    @Test
//    public void getCodeNameByCodeNoAndItemNo() {
//        try{
//            //        codeLibraryServiceImpl2.queryCode("ApplyChannel","00");
//           String name1 = codeLibraryServiceImpl2.getCodeNameByCodeNoAndItemNo("ApplyChannel","00");
//            Thread.sleep( 1000);
//            //@Cacheable(key ="'name'+#p0+#p1")
////            String redisTemplateStr = (String)redisTemplate.opsForValue().get("nameApplyChannel00");
////            String redisTemplateStr = (String)redisTemplate.opsForValue().get("myCache::userName");
//            String redisTemplateStr = (String)redisTemplate.opsForValue().get("userName");
//            logger.info("redisTemplateStr =【{}】",redisTemplateStr);
//            String name2 = codeLibraryServiceImpl2.getCodeNameByCodeNoAndItemNo("ApplyChannel","00");
////            Thread.sleep( 5000);
//           String name3 =  codeLibraryServiceImpl2.getCodeNameByCodeNoAndItemNo("ApplyChannel","00");
//            logger.info("name1 = {},name2 = {},name3 = {}"+name1,name2,name3);
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    /**
     * 功能描述: <br> 测试下Redis是否集成功。
     * 参考 ：https://blog.csdn.net/guijiaoba/article/details/78574600
     * @Param:
     * @Return:
     * @Author: MG01972
     * @Date: 2019-09-25 16:54:17
     */
//    @Test
//    public void redisTest(){
//        redisTemplate.opsForValue().set("hello", "world2");
//        String value = (String)redisTemplate.opsForValue().get("hello");
//        logger.info("value1="+value);
//
////        redisTemplate.delete("hello");
//
//        value = (String)redisTemplate.opsForValue().get("hello");
//        logger.info("value2="+value);
//    }

    @Test
    public void test2(){
        try {
//            assetInfoService2.pushDataToBIByStatus("02");
//            SpringApplication.run(PushdataApplication.class, args);
//            PushdataApplication.main();
//            PushdataApplicationTests
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 功能描述: <br>测试缓存注解, 启动时加上注解 @EnableCaching (开启缓存) 即可实现redis的缓存,如果不加这注解，也不会报错，就是不会用缓存而已
     * @Param:
     * @Return:
     * @Author: MG01972
     * @Date: 2019-10-09 14:46:02
     */
    @Test
    public void test3(){

        logger.info("-------先清除缓存-------------");
        codeLibraryMapper.removeFromCache();
        logger.info("-------第一次查询-------------");
        List<CodeLibrary> list =  codeLibraryMapper.getCodeNameByCodeNo("YesNo");
        logger.info("list={}",list);
        logger.info("-------第二次查询-------------");//直接用了缓存的数据
        List<CodeLibrary> list2 =  codeLibraryMapper.getCodeNameByCodeNo("YesNo");
        logger.info("list2={}",list2);
        logger.info("-------清除缓存-------------");
        codeLibraryMapper.removeFromCache();
        logger.info("-------第三次查询-------------");//删除缓存数据后，重新去数据库查询了
        List<CodeLibrary> list3 =  codeLibraryMapper.getCodeNameByCodeNo("YesNo");
        logger.info("list3={}",list3);
        String itemName =  codeLibraryMapper.getCodeNameByCodeNoAndItemNo("YesNo","1");
        logger.info("itemName={}",itemName);


    }

//    @CacheEvict(value = "codeLibraryCache1",allEntries = true,beforeInvocation = true)
//    public void removeFromCache(){
//
//    }
    @Test
    public void getUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserid("hp11");
        userInfo.setStatus("2");
        List<UserInfo> userInfoList = userInfoMapper.getUserInfo(userInfo);
        logger.info("userInfoList={}",userInfoList);
        logger.info("----------------分割綫----------------------------");
        List<UserInfo> userInfoList2 = userInfoMapper.getUserInfo(userInfo);
        logger.info("userInfoList2={}",userInfoList2);
    }
}
