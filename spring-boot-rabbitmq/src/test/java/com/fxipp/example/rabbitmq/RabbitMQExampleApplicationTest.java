package com.fxipp.example.rabbitmq;

import com.fxipp.example.rabbitmq.constants.MqConstant;
import com.fxipp.example.rabbitmq.sender.RabbitSender;
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
