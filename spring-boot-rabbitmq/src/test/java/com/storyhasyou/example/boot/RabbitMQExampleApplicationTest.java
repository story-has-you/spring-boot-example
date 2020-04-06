package com.storyhasyou.example.boot;

import com.storyhasyou.example.boot.config.DelayedConfig;
import com.storyhasyou.example.boot.constants.MqConstant;
import com.storyhasyou.example.boot.sender.RabbitSender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        rabbitSender.sendDelay("hello delay", MqConstant.DEAD_EXCHANGE, MqConstant.DEAD_ROUTING_KEY, 10000);
        log.info("已发送延迟队列消息");
    }

    @Test
    public void send2() {
        rabbitSender.sendDelay("hello delay", DelayedConfig.EXCHANGE_NAME, DelayedConfig.QUEUE_NAME, 10000);
        log.info("已发送延迟队列消息");
    }
}
