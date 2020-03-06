package com.storyhasyou.example.rabbitmq.constants;

/**
 * @author fangxi
 * @date 2020/2/26
 */
public interface MqConstant {

    String QUEUE = "test-queue";
    String DELAY_QUEUE = "test-delay-queue";
    String DEAD_QUEUE = "dead-letter-queue";

    String EXCHANGE = "test-exchange";
    String DELAY_EXCHANGE = "test-delay-exchange";
    String DEAD_EXCHANGE = "dead-letter-exchange";


    String ROUTING_KEY = "test-routingKey.*";
    String DELAY_ROUTING_KEY = "test-delay-routingKey.*";
    String DEAD_ROUTING_KEY = "dead-letter-routingKey.*";

}
