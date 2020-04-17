package com.example.eureka_client.xdclass.jdk.jdk8.lambda;

import java.util.function.Function;

public class FunctionObj implements Function {

    @Override
    public Object apply(Object o) {
        return o+",测试实现接口方法";
    }
}
