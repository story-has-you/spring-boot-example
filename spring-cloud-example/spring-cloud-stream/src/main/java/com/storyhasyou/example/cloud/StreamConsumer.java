package com.storyhasyou.example.cloud;

import com.storyhasyou.example.cloud.topic.MyTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * @author fangxi
 * @date 2020/4/6
 */
@Slf4j
@Component
public class StreamConsumer {

    /**
     * 监听input信道
     * @param payload
     */
    @StreamListener(Sink.INPUT)
    public void cunsume(Object payload) {
        log.info("message consumed successfully, paylaod = {}", payload);
    }

    @StreamListener(MyTopic.INPUT)
    public void cunsumeMyMessage(Object payload) {
        log.info("MyTopic consumed successfully, paylaod = {}", payload);
    }

}
