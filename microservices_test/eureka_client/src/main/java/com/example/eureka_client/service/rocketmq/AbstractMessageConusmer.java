package com.example.eureka_client.service.rocketmq;


import com.example.eureka_client.util.ByteUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;

public class AbstractMessageConusmer<T> {

    /**
     * 重试消费消息，这是自己写的
     * @param status
     * @return
     */
    public static ConsumeConcurrentlyStatus processMessage(byte[] message) {

        try {
             System.out.println(" Receive New Messages: " + new String(message));

        } catch (Exception e) {
            e.printStackTrace();
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;// 重试
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;

    }

}
