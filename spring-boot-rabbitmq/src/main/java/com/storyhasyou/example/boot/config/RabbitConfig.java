package com.storyhasyou.example.boot.config;

import com.storyhasyou.example.boot.constants.MqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author fangxi
 * @date 2020/3/6
 */
@Configuration
public class RabbitConfig {

    /**
     * 创建死信队列(缓冲队列)
     */
    @Bean
    public Queue deadLetterQueue() {
        HashMap<String, Object> map = new HashMap<>(2);
        // 出现dead letter之后将dead letter重新发送到指定exchange
        map.put("x-dead-letter-exchange", MqConstant.DEAD_EXCHANGE);
        // 出现dead letter之后将dead letter重新按照指定的routing-key发送
        map.put("x-dead-letter-routing-key", MqConstant.DELAY_ROUTING_KEY);
        return QueueBuilder.nonDurable(MqConstant.DEAD_QUEUE).withArguments(map).build();
    }

    /**
     * 创建死信队列的交换机（direct类型交换机）
     *
     */
    @Bean
    public Exchange deadLetterExchange() {
        return ExchangeBuilder.directExchange(MqConstant.DEAD_EXCHANGE).durable(true).build();
    }

    /**
     * 将 死信队列 与 死信队列的交换机 绑定
     */
    @Bean
    public Binding deadLetterBinding(Queue deadLetterQueue, Exchange deadLetterExchange) {
        return BindingBuilder.bind(deadLetterQueue).to(deadLetterExchange).with(MqConstant.DEAD_ROUTING_KEY).noargs();
    }

    /**
     * 创建需要被消费的队列
     */
    @Bean
    public Queue redirectQueue() {
        return QueueBuilder.nonDurable(MqConstant.DELAY_QUEUE).build();
    }


    /**
     * 将需要消费的队列 与 死信队列和死信队列的交换机绑定
     */
    @Bean
    public Binding redirectBinding(Queue redirectQueue, Exchange deadLetterExchange) {
        return BindingBuilder.bind(redirectQueue).to(deadLetterExchange).with(MqConstant.DELAY_ROUTING_KEY).noargs();
    }
}
