
package com.example.eureka_client.rocketmq;


import com.example.eureka_client.EurekaClientApplicationTests;
import com.example.eureka_client.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class RocketMqProducerTest extends EurekaClientApplicationTests {

	private static Logger logger = LoggerFactory.getLogger(RocketMqProducerTest.class.getName());

    @Autowired
    private ProducerService producer;

	@Test
	public void testAddOpinion1() {
		try {
			long t = System.currentTimeMillis();
			    producer.send("test1", "push", "123");
			System.out.println(System.currentTimeMillis() - t);
			logger.error("------------------");
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

