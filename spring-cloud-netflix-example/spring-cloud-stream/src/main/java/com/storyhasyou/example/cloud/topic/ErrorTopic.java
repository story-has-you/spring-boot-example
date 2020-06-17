package com.storyhasyou.example.cloud.topic;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author fangxi
 * @date 2020/4/6
 */
public interface ErrorTopic {

    String INPUT = "error-input";
    String OUTPUT = "error-output";


    @Input(INPUT)
    SubscribableChannel input();

    @Output(OUTPUT)
    MessageChannel output();


}
