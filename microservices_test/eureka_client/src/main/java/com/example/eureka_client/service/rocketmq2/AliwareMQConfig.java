package com.example.eureka_client.service.rocketmq2;

import com.aliyun.openservices.ons.api.PropertyKeyConst;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class AliwareMQConfig implements InitializingBean {

    //TOPIC config
    @Value("${aliyun.mq.topic.chebabaCouponTopic:}")
    public String chebabaCouponTopic;

    @Value("${aliyun.mq.topic.chebabaCouponNotifyTopic:}")
    public String chebabaCouponNotifyTopic;

    @Value("${aliyun.mq.producerid:}")
    public String producerId;

    @Value("${aliyun.mq.accesss_key:}")
    public String accessKey;

    @Value("${aliyun.mq.secret_key:}")
    public String secretKey;

    @Value("${aliyun.mq.onsaddr:}")
    public String onsaddr;

    @Value("${aliyun.mq.consumerid.coupon:}")
    public String chebabaCouponConsumerId;



    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getOnsaddr() {
        return onsaddr;
    }

    public void setOnsaddr(String onsaddr) {
        this.onsaddr = onsaddr;
    }

    public String getChebabaCouponTopic() {
        return chebabaCouponTopic;
    }


    public void setChebabaCouponTopic(String chebabaCouponTopic) {
        this.chebabaCouponTopic = chebabaCouponTopic;
    }

    public String getChebabaCouponConsumerId() {
        return chebabaCouponConsumerId;
    }

    public void setChebabaCouponConsumerId(String chebabaCouponConsumerId) {
        this.chebabaCouponConsumerId = chebabaCouponConsumerId;
    }

    public String getChebabaCouponNotifyTopic() {
        return chebabaCouponNotifyTopic;
    }

    public void setChebabaCouponNotifyTopic(String chebabaCouponNotifyTopic) {
        this.chebabaCouponNotifyTopic = chebabaCouponNotifyTopic;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Properties mqProperties = new Properties();
        mqProperties.setProperty(PropertyKeyConst.ProducerId, producerId);
        mqProperties.setProperty(PropertyKeyConst.AccessKey, accessKey);
        mqProperties.setProperty(PropertyKeyConst.SecretKey, secretKey);
        mqProperties.setProperty(PropertyKeyConst.ONSAddr, onsaddr);
        this.properties = mqProperties;
    }

}
