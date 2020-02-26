package com.fxipp.example;

import com.fxipp.example.constants.MqConstant;
import com.fxipp.example.sender.RabbitSender;
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
