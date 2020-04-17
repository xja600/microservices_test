package com.example.eureka_client.exception;

import java.io.Serializable;

public class MQException extends RuntimeException implements Serializable {


    public MQException(Throwable message) {
        super(message);
    }
}
