package com.example.eureka_client.service.rocketmq3.rocketMQDemo;

import java.util.List;
import java.util.Random;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

/**
 *  当前例子是PushConsumer用法，使用方式给用户感觉是消息从RocketMQ服务器推到了应用客户端。<br> 
  	但是实际PushConsumer内部是使用长轮询Pull方式从Broker拉消息，然后再回调用户Listener方法
 * @author Administrator
 *
 */
@Component
public class PushConsumer {  
	  
	
    public static void main(String[] args) throws InterruptedException, MQClientException {  
        /** 
         * 一个应用创建一个Consumer，由应用来维护此对象，可以设置为全局对象或者单例<br> 
         * 注意：ConsumerGroupName需要由应用来保证唯一 
         */  
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("testmerchantLeagueConsumerGroup");  
        consumer.setNamesrvAddr("127.0.0.1:9876");
          
        /** 
         * 订阅指定topic下tags分别等于TagA或TagB 
         */  
        consumer.subscribe("broker-a", "TagB || TagA");  
  
        /** 
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br> 
         * 如果非第一次启动，那么按照上次消费的位置继续消费 
         */  
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);  
  
        consumer.registerMessageListener(new MessageListenerConcurrently() {  
  
            // 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息 
            @Override  
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {  
                System.out.println(Thread.currentThread().getName() + " Receive New Messages: " + msgs);  
                MessageExt msg = msgs.get(0);  
                
                
                if (msg.getTopic().equals("broker-a")) {  
                    // 执行TopicTest1的消费逻辑  
                    if (msg.getTags() != null && msg.getTags().equals("TagA")) {  
                        // 执行TagA的消费  
                        String message = new String(msg.getBody());  
                        System.out.println(message);  
                    } else if (msg.getTags() != null && msg.getTags().equals("TagB")) {  
                        // 执行TagB的消费  
                        String message = new String(msg.getBody());  
                        System.out.println(message);  
                    }  
                } 
                
                try {
                	int a = new Random().nextInt(2);
                	// 业务处理，模拟消费异常
                	if(a != 2){
                		throw new Exception();
                	}
                	
				} catch (Exception e) {
					// 如果消费重试次数 等于3，则返回失败
					if(msg.getReconsumeTimes() == 2){    // 次数从0开始的
						System.out.println("消费了3次，将此条信息插入到数据库啦！");
						// 模拟插入数据库操作
						try {
							Thread.sleep(10);
						} catch (InterruptedException e1) {
						}
						// 消费了3次都失败了，就可以将这条消息存储到DB 或者 LOG中，采用其他的方式处理，例如：开一个Task 定时轮训 失败的表  ; 或者 在后台人工处理
						return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
					}
					return ConsumeConcurrentlyStatus.RECONSUME_LATER;
				}
                
                //消费者向mq服务器返回消费成功的消息  
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;  
            }  
        });  
  
        // Consumer对象在使用之前必须要调用start初始化，初始化一次即可
        consumer.start();  
  
        System.out.println("Consumer Started.");  
    }  
}  