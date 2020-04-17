package com.example.eureka_client.config;

import com.alibaba.fastjson.JSON;
import com.example.eureka_client.domain.ExceptionEntity;
import com.example.eureka_client.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;
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
public class Aspect {

    private static final Logger LOG = LoggerFactory.getLogger(Aspect.class);


//    @Pointcut("execution(* com.example.eureka_client.aspect.*.*(..))" )
    @Pointcut("execution(* com.example.eureka_client.controller.*.*(..))" )
    public void pointCut(){}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String name = StringUtils.join(pjp.getSignature().getDeclaringTypeName(),".", pjp.getSignature().getName());
        String req = JSON.toJSONString(pjp.getArgs());

        try {
            LOG.info("-----【{}】---- 进入Feign调用... request: 【{}】", name, req);
            long l = System.currentTimeMillis();
            Object proceed = pjp.proceed();
            String resp = JSON.toJSONString(proceed);
            LOG.info("-----【{}】---- 退出Feign调用... request: 【{}】, response: 【{}】 :调用处理时间 【{}】", name, req, resp,(System.currentTimeMillis()-l));
            return proceed;
        } catch (SocketTimeoutException e){
            LOG.error("feign_timeout", e);
            throw new CommonException(exceptionInfo(pjp));
        }catch (Exception e){
            LOG.error("feign_aspect", e);
            throw new CommonException(exceptionInfo(pjp));
        }
    }
    public String exceptionInfo(ProceedingJoinPoint point){
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        exceptionEntity.setDescription("调用外部系统异常");
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        exceptionEntity.setClassName(className);
        exceptionEntity.setMethodName(methodName);
        //请求的参数
        Object[] args = point.getArgs();
        String params = com.aliyun.openservices.shade.com.alibaba.fastjson.JSON.toJSONString(args[0]);
        exceptionEntity.setParams(params);
        return String.format("调用描述：异常信息[%s]==调用类[%s]==调用方法[%s]==调用参数[%s]",
                exceptionEntity.getDescription(),exceptionEntity.getClassName(),
                exceptionEntity.getMethodName(),exceptionEntity.getParams());
    }

}
