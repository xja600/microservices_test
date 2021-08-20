/*
package com.example.eureka_client.service.rocketmq2;


import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.SendCallback;
import com.aliyun.openservices.ons.api.SendResult;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "aliyun.producer.enable", havingValue = "rocketMQ", matchIfMissing = false)
public class RocketMQConfig {

    private final static Logger logger = LoggerFactory.getLogger(RocketMQConfig.class);


    @Value("${aliyun.mq.onsaddr}")
    private String namesrvAddr;

    //System.setProperty("rocketmq.client.log.loadconfig","false");

    @Bean
    public Producer rocketMQProducer() throws MQClientException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("aliPayProducer");
        defaultMQProducer.setNamesrvAddr(namesrvAddr);
        defaultMQProducer.start();
        return new Producer() {

            @Override
            public boolean isStarted() {
                return true;
            }

            @Override
            public boolean isClosed() {
                return false;
            }

            @Override
            public void start() {
            }

            @Override
            public void shutdown() {
            }

            @Override
            public SendResult send(Message message) {
                org.apache.rocketmq.common.message.Message mqMessage = new org.apache.rocketmq.common.message.Message();
                mqMessage.setBody(message.getBody());
                mqMessage.setTopic(message.getTopic());
                mqMessage.setTags(message.getTag());
                if (message.getStartDeliverTime() > 0) {
                    //1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
                    mqMessage.setDelayTimeLevel(3);//统一延迟10S处理
                }
                SendResult result = new SendResult();
                try {
                    org.apache.rocketmq.client.producer.SendResult send = defaultMQProducer
                            .send(mqMessage);
                    result.setMessageId(send.getMsgId());
                    result.setTopic(message.getTopic());

                } catch (Exception e) {
                    logger.error("发送本地rocketMQ消息异常", e);
                    result = new SendResult();
                }

                return result;
            }

            @Override
            public void sendOneway(Message message) {
            }

            @Override
            public void sendAsync(Message message, SendCallback sendCallback) {
                logger.debug("[模拟发送异步MQ信息]:{}", message);
            }
        };
    }

    @Autowired
    private AliwareMQConfig aliwareMQConfig;

    */
/**
     * 使用阿里云Consumer的默认配置，默认启动20个消费者进程，最大支持64个消费者
     *
     * @return
     *//*

    @Bean(name = "couponConsumer")
    public DefaultMQPushConsumer cluePersistenceConsumer() {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(aliwareMQConfig.getChebabaCouponConsumerId());
        try {
            consumer.setNamesrvAddr(namesrvAddr);
            consumer.subscribe(aliwareMQConfig.getChebabaCouponTopic(), "*");
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext context) {
                    Message message = new Message();
                    message.setBody(msgs.get(0).getBody());
                    message.setTag(msgs.get(0).getTags());
                    MessageListener listener = GetSpringBeanUtil.getBean("couponMQListener",
                            MessageListener.class);
                    return RocketMQConfig.transform(listener.consume(message, null));
                }

            });
            consumer.start();
        } catch (Exception e) {
            logger.error("couponConsumer init error", e);
        }

        logger.info("couponConsumer  RocketMQ 初始化完成:{}", namesrvAddr);

        return consumer;
    }


    public static ConsumeConcurrentlyStatus transform(Action status) {

        if (Action.CommitMessage.equals(status)) {
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        } else {
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
    }




}
*/
