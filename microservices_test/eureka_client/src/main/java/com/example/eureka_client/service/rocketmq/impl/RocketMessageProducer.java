package com.example.eureka_client.service.rocketmq.impl;

import java.io.Serializable;

import com.example.eureka_client.exception.MQException;
import com.example.eureka_client.service.rocketmq.MessageProducer;
import com.example.eureka_client.util.ByteUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.JmsException;


/**
 * @author lishangjiang
 * 
 */
public class RocketMessageProducer implements MessageProducer {

	private final static Logger logger = LoggerFactory.getLogger(RocketMessageProducer.class);

	private RocketMQProducer producer;
	
	private String topic, tag, key;	

	public void sendByte(byte[] message) throws JmsException {
        Message msg = new Message(topic, tag, key, message);
        try {
			SendResult result = producer.send(msg);
			logger.info("msgId=" + result.getMsgId());
		} catch (MQClientException | RemotingException | MQBrokerException
				| InterruptedException e) {
			logger.error(e.getMessage());
			throw new MQException(e);
		}  
	}

	@Override
	public void sendObject(Serializable message) throws JmsException {		
		Message msg = new Message(topic, tag, key, ByteUtils.toBytes(message));
        try {
			SendResult result = producer.send(msg);
			logger.info("msgId=" + result.getMsgId());
		} catch (MQClientException | RemotingException | MQBrokerException
				| InterruptedException e) {
			logger.error(e.getMessage());
			throw new MQException(e);
		}  
	}

	@Override
	public void sendText(String message) throws JmsException {
		Message msg = new Message(topic, tag, key, ByteUtils.toBytes(message));
        try {
			SendResult result = producer.send(msg);
			logger.info("msgId=" + result.getMsgId());
		} catch (MQClientException | RemotingException | MQBrokerException
				| InterruptedException e) {
			logger.error(e.getMessage());
			throw new MQException(e);
		}
	}

	public void setProducer(RocketMQProducer producer) {
		this.producer = producer;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public void destory() {
		try {
			producer.shutdown();
		} catch (Exception e) {
		}
	}

}
