package com.example.eureka_client.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * 例： execution (* com.sample.service..*. *(..))
 *
 * 整个表达式可以分为五个部分：
 *
 * 1、execution():：表达式主体。
 *
 * 2、第一个*号：表示返回类型， *号表示所有的类型。
 *
 * 3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service包、子孙包下所有类的方法。
 *
 * 4、第二个*号：表示类名，*号表示所有的类。
 *
 * 5、*(..)：最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
 */
@Slf4j
@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.example.eureka_client.controller..*.*(..))")
    //配置多个 ，参考：https://blog.csdn.net/taotao_guiwang/article/details/101061990
    //+"||execution(* com.example.eureka_client.service..*.*(..))")
    public void logPointcut(){
    }

    @Before("logPointcut()")
    public void  methodBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //打印请求内容
        System.out.println("---------------logPointcut-------------------");
        log.info("---------------请求内容---------------");
        log.info("请求地址:"+request.getRequestURL().toString());
        log.info("请求方式:"+request.getMethod());
        log.info("请求类方法:"+joinPoint.getSignature().getName());
        log.info("请求类方法参数:"+ Arrays.toString(joinPoint.getArgs()));
        log.info("---------------请求内容---------------");
    }


    @AfterReturning(returning = "o",pointcut = "logPointcut()")
    public void methodAfterReturning(Object o){
        log.info("===============返回内容===============");
        log.info("返回的内容:"+ o.toString());
        log.info("===============返回内容===============");
    }


    @AfterThrowing(pointcut = "logPointcut()",throwing = "e")
    public void logThrowing(JoinPoint joinPoint,Throwable e){
        log.info("***************抛出异常***************");

        log.info("请求类方法:"+joinPoint.getSignature().getName());
        log.info("异常内容:"+e);
        log.info("***************抛出异常***************");
    }

}

