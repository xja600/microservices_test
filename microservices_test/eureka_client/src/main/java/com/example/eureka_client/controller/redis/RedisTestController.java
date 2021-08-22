package com.example.eureka_client.controller.redis;

import com.example.eureka_client.aspect.RedisLock;
import com.example.eureka_client.service.redis.util.RedisUtil;
import com.example.eureka_client.service.userinfo.impl.UserInfoServiceImpl;
import com.spring.dao.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin  //解决跨域的问题，https://www.cnblogs.com/vandusty/p/11408422.html
@Controller
@RequestMapping("/redis/test/")
public class RedisTestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisTestController.class);
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserInfoServiceImpl userInfoService;

    /**
     * 设置字符串值
     * postman: http://localhost:8771/redis/test/setStrValue?key=a&value=1
     */
    @RequestMapping("setStrValue")
    @ResponseBody
    public String setStrValue(String key,String value){
        LOGGER.info("---setStrValue()-key={},value={}",key,value);
        redisUtil.set(key,value);
        return "success";
    }

    /**
     * 获取字符串值
     * postman: http://localhost:8771/redis/test/getStrValue?key=a
     * @return
     */
    @RequestMapping("getStrValue")
    @ResponseBody
    public Object getStrValue(String key){
        Object value = redisUtil.get(key);
        LOGGER.info("---getStrValue()-key={},value={}",key,value);
        return value;
    }

    /**
     * postman: http://localhost:8771/redis/test/getUserInfoList?userId=test86
     * @param userId
     * @return
     */
    @RequestMapping("getUserInfoList")
    @ResponseBody
    public List<UserInfo> getUserInfo(String userId){

        return userInfoService.getUserInfo(userId);
    }

}
