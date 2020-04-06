package com.storyhasyou.example.boot.receive;

import com.rabbitmq.client.Channel;
import com.storyhasyou.example.boot.config.DelayedConfig;
import com.storyhasyou.example.boot.constants.MqConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @author fangxi
 * 多个消费者消费同一个队列
 */
@Slf4j
@Component
public class RabbitReceive {

    /**
     * 接受mq消息
     */
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = MqConstant.QUEUE, durable = "true"),
                    exchange = @Exchange(value = MqConstant.EXCHANGE, type = "topic", ignoreDeclarationExceptions = "true"),
                    key = MqConstant.ROUTING_KEY
            )
    )
    public void onMessage(Message<String> message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        log.info("onMessage1: {}", message.getPayload());
        // 业务处理完毕之后，需要手动ack操作，配置文件配置了手动操作
        channel.basicAck(tag, false);
    }


    @RabbitListener(queues = MqConstant.DELAY_QUEUE)
    public void delay(Message<String> message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        log.info("延迟队列: {}", message.getPayload());
        channel.basicAck(tag, false);
    }

    /**
     * 监听插件实现的延迟队列
     * @param message
     * @param channel
     * @param tag
     * @throws Exception
     */
    @RabbitListener(queues = DelayedConfig.QUEUE_NAME)
    public void delayByPlugins(Message<String> message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        log.info("插件实现的延迟队列: {}", message.getPayload());
        channel.basicAck(tag, false);
    }

}
