package com.example.eureka_client.service.rocketmq;

import java.util.List;

import com.example.eureka_client.util.ByteUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author lishangjiang
 * 
 */
public abstract class RocketmqMessageReceiver extends AbstractMessageConusmer<Object> {
	
	private final static Logger logger = LoggerFactory.getLogger(RocketmqMessageReceiver.class);
	
	private RocketMQPushConsumer consumer;
	
	private String topic;
	
	private String tags;
				
	protected void init() throws MQClientException {
        consumer.subscribe(topic, tags);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);  
        consumer.registerMessageListener(new MessageListenerConcurrently() {
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext context) {
                    Message msg = list.get(0);
                    logger.info(msg.toString());
                    Object message = ByteUtils.fromByte(msg.getBody());
//                    processMessage(message);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            }
        );
        consumer.start();
	}

	public void setTopic(String topic) {
		this.topic = topic.trim().replaceAll(" ", "");
	}
	
	public void setConsumer(RocketMQPushConsumer consumer) {
		this.consumer = consumer;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
	
}
