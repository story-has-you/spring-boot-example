package com.fxipp.example;

import com.fxipp.example.sender.RabbitSender;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author fangxi
 */
@SpringBootTest
public class RabbitMQExampleApplicationTest {

    @Autowired
    private RabbitSender rabbitSender;

    @Test
    public void send() {
        Map<String, Object> properites = ImmutableMap.of("timestamp", LocalDateTime.now(), "sender", "fangxi");
        rabbitSender.send("Hello RabbitMQ~~~", properites);
    }
}
