package com.storyhasyou.example.rabbitmq.sender;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

/**
 * @author fangxi
 */
@Slf4j
@Component
public class RabbitSender {

    /**
     * 确认消息的回掉监听，用于确认消息是否被收到
     * <p>
     * CorrelationData correlationData, boolean ack, String cause
     * <p>
     * correlationData: 作为一个唯一标示
     * ack: true | false 消息是否落盘成功
     * cause: 失败的一些信息
     */
    final RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, ack, cause) -> {
        log.info("消息ack结果: {}, correlationData: {}", ack, correlationData);

    };
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息的方法
     *
     * @param body       消息主体
     */
    public <T> void send(T body, String exchange, String routingKey) {
        this.send(body, Maps.newHashMap(), exchange, routingKey);

    }

    public <T> void send(T body, Map<String, Object> properties, String exchange, String routingKey) {
        log.info("发送mq消息, 内容: {}, 附加属性: {}, wxchange: {}, routingKey: {}", body, properties, exchange, routingKey);
        // 构造消息
        MessageHeaders messageHeaders = new MessageHeaders(properties);
        Message<T> msg = MessageBuilder.createMessage(body, messageHeaders);

        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        // 设置回调
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.convertAndSend(exchange,
                routingKey,
                msg,
                correlationData);

    }


}