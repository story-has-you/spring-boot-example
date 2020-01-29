package com.fxipp.example.receive;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author fangxi
 */
@Slf4j
@Component
public class RabbitReceive {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "queue-1",durable = "true"),
                    exchange = @Exchange(value = "exchange-1", type = "topic", ignoreDeclarationExceptions = "true"),
                    key = "spring-boot-example.*"
            )
    )
    public void onMessage(Message<Object> message, Channel channel) throws Exception{
        log.info("消费者收到消息: {}", message.getPayload());
        // 业务处理完毕之后，需要手动ack操作，配置文件配置了手动操作
        long deliveryTag = (long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }

}
