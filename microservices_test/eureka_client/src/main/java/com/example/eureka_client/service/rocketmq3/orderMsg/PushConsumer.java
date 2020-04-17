package com.example.eureka_client.service.rocketmq3.orderMsg;

import java.util.List;
import java.util.Random;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

public class PushConsumer {  
	  
    /** 
     * 当前例子是PushConsumer用法，使用方式给用户感觉是消息从RocketMQ服务器推到了应用客户端。<br> 
     * 但是实际PushConsumer内部是使用长轮询Pull方式从Broker拉消息，然后再回调用户Listener方法<br> 
     * @throws MQClientException  
     */  
    public static void main(String[] args) throws InterruptedException, MQClientException {  
        /** 
         * 一个应用创建一个Consumer，由应用来维护此对象，可以设置为全局对象或者单例<br> 
         * 注意：ConsumerGroupName需要由应用来保证唯一 
         */  
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerGroup");  
        consumer.setNamesrvAddr("127.0.0.1:9876");
          
        /** 
         * 订阅指定topic下tags分别等于createTag  payTag  sendTag
         */  
        consumer.subscribe("OrderTopic", "createTag || payTag || sendTag");  
        
        // 消费者 线程数 最小 最大 线程数
//        consumer.setConsumeThreadMin(10);
//        consumer.setConsumeThreadMax(20);
  
        /** 
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br> 
         * 如果非第一次启动，那么按照上次消费的位置继续消费 
         */  
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);  
  
        consumer.registerMessageListener(new MessageListenerOrderly() {
			
            /** 
             * 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息 
             */  
            @Override  
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {  
                try {
                	// 模拟业务处理的时间
                	Thread.sleep(new Random().nextInt(1000));
                	System.out.println(new String(msgs.get(0).getBody(),"UTF-8"));
				} catch (Exception e) {
					e.printStackTrace();
				}
               return ConsumeOrderlyStatus.SUCCESS;
            }  
        });  
  
        /** 
         * Consumer对象在使用之前必须要调用start初始化，初始化一次即可<br> 
         */  
        consumer.start();  
  
        System.out.println("Consumer Started.");  
    }  
}  