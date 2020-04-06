package com.storyhasyou.example.boot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangxi
 * @date 2020/4/6
 * 使用延迟插件实现延迟队列
 */
@Configuration
public class DelayedConfig {

    public final static String QUEUE_NAME = "delayed.goods.order";
    public final static String EXCHANGE_NAME = "delayedec";

    @Bean
    public Queue queue() {
        return QueueBuilder.nonDurable(DelayedConfig.QUEUE_NAME).build();
    }

    /**
     * 默认交换机
     * @return
     */
    @Bean
    public CustomExchange customExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        //参数二为类型：必须是x-delayed-message
        return new CustomExchange(DelayedConfig.EXCHANGE_NAME, "x-delayed-message", true, false, args);
    }

    /**
     * 绑定队列到交换器
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding binding(Queue queue, CustomExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DelayedConfig.QUEUE_NAME).noargs();
    }

}
