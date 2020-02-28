package com.storyhasyou.example.rabbitmq;

import com.storyhasyou.example.rabbitmq.constants.MqConstant;
import com.storyhasyou.example.rabbitmq.sender.RabbitSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author fangxi
 */
@SpringBootTest
public class RabbitMQExampleApplicationTest {

    @Autowired
    private RabbitSender rabbitSender;

    @Test
    public void send() {
        for (int i = 0; i < 50; i++) {
            rabbitSender.send(i + "", MqConstant.WXCHANGE, MqConstant.ROUTING_KEY);
        }
    }
}
