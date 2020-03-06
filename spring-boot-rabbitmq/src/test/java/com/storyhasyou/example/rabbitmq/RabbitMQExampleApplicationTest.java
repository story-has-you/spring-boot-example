package com.storyhasyou.example.rabbitmq;

import com.storyhasyou.example.rabbitmq.constants.MqConstant;
import com.storyhasyou.example.rabbitmq.sender.RabbitSender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @author fangxi
 */
@Slf4j
@SpringBootTest
public class RabbitMQExampleApplicationTest {

    @Autowired
    private RabbitSender rabbitSender;

    @Test
    public void send() {
        rabbitSender.sendDelay("hello delay", MqConstant.DEAD_EXCHANGE, MqConstant.DEAD_ROUTING_KEY, message -> {
            MessageProperties messageProperties = message.getMessageProperties();
            messageProperties.setExpiration(String.valueOf(TimeUnit.SECONDS.toMillis(10)));
            return message;
        });
        log.info("已发送延迟队列消息");
    }
}
