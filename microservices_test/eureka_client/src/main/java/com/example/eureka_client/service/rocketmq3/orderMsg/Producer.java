package com.example.eureka_client.service.rocketmq3.orderMsg;

import java.util.List;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * 顺序消息模式
 * @author Administrator
 *
 */
public class Producer {  
	
    public static void main(String[] args) throws MQClientException, RemotingException, MQBrokerException, InterruptedException{  
     
        DefaultMQProducer producer = new DefaultMQProducer("OrderProducer");  
          
        producer.setNamesrvAddr("127.0.0.1:9876");
        // 发送消息失败重试的次数
        producer.setRetryTimesWhenSendFailed(3);
        /** 
         * Producer对象在使用之前必须要调用start初始化，初始化一次即可<br> 
         * 注意：切记不可以在每次发送消息时，都调用start方法 
         */  
        producer.start();  
        
        String[] tags = {"createTag", "payTag" , "sendTag"};
  
        for(int orderId = 0; orderId < 10 ; orderId++){     //  订单消息，模拟10个订单
        	
        	for(int type = 0 ; type < 3; type ++){  // 每种订单分为 创建订单、支付订单、发货订单


        		Message message = new Message("OrderTopic1", tags[type % tags.length], orderId + ";" + type, ("订单" + orderId + "--->订单种类：" + type).getBytes());
//				producer.createTopic("","");
        		SendResult sendResult = producer.send(message, new MessageQueueSelector() {
					@Override
					public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
						Integer id = (Integer)arg;
						int index = id % mqs.size();
						return mqs.get(index);
					}
				}, orderId);
        		
        		System.out.println(sendResult);
        	}
        }
        
        /** 
         * 应用退出时，要调用shutdown来清理资源，关闭网络连接，从MetaQ服务器上注销自己 
         * 注意：我们建议应用在JBOSS、Tomcat等容器的退出钩子里调用shutdown方法 
         */  
        producer.shutdown();  
    }  
}