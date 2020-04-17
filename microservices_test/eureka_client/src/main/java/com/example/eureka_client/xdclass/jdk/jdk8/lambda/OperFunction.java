package com.example.eureka_client.xdclass.jdk.jdk8.lambda;

@FunctionalInterface
public interface OperFunction<R,T>  {
    R operate(T t1,T t2);
}
