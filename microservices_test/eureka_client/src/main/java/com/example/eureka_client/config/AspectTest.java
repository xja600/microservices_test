package com.example.eureka_client.config;

import com.alibaba.fastjson.JSON;
import com.example.eureka_client.domain.ExceptionEntity;
import com.example.eureka_client.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.net.SocketTimeoutException;

/**
 * @author MG01972
 * @date 2019-10-09 16:54:53
 *
 */
@org.aspectj.lang.annotation.Aspect
@Component
@Slf4j
public class AspectTest {

    private static final Logger LOG = LoggerFactory.getLogger(AspectTest.class);


    @Pointcut("execution(* com.example.eureka_client.controller.*.*(..))" )
    public void pointCut(){}

    //@Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        try {
            LOG.info("---------调用方法前--------------");
            //访问目标方法的参数：
            Object[] args = point.getArgs();
            if (args != null && args.length > 0 && args[0].getClass() == String.class) {
                args[0] = "改变后的参数1";
            }
            //用改变后的参数执行目标方法
            Object returnValue = point.proceed(args);
            LOG.info("@Around：执行目标方法之后...");
            LOG.info("@Around：被织入的目标对象为：" + point.getTarget());
            return "原返回值：" + returnValue + "，这是返回结果的后缀";

        }catch (Exception e){
            LOG.error("失败：", e);
//            throw new CommonException(exceptionInfo(point));
            throw new CommonException("失败："+e.getMessage());
        }
    }

}
