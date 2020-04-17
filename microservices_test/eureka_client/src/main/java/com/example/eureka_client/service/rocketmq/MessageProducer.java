package com.example.eureka_client.service.rocketmq;

import org.springframework.jms.JmsException;

import java.io.Serializable;

public interface MessageProducer {

     void sendObject(Serializable message) throws JmsException ;
     void sendText(String message) throws JmsException;
}
