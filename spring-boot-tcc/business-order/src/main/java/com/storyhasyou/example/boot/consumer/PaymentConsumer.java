package com.storyhasyou.example.boot.consumer;

import com.rabbitmq.client.Channel;
import com.storyhasyou.example.boot.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Slf4j
@Component
public class PaymentConsumer {

    @Autowired
    private OrderService orderService;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "pay",durable = "true"),
                    exchange = @Exchange(value = "tcc", type = "topic", ignoreDeclarationExceptions = "true"),
                    key = "tcc.payment"
            )
    )
    public void onMessage(Message<Long> message, Channel channel) throws Exception{
        Long payload = message.getPayload();
        log.info("mq接受消息: {}", payload);
        String status = orderService.updateOrderStatus(payload);
        long deliveryTag = (long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        if ("success".equals(status)) {
            // 业务处理完毕之后，需要手动ack操作，配置文件配置了手动操作
            channel.basicAck(deliveryTag, false);
        } else {
            channel.basicReject(deliveryTag, false);
        }

    }

}
