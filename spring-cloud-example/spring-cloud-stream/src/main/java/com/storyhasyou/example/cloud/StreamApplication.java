package com.storyhasyou.example.cloud;

import com.storyhasyou.example.cloud.topic.GroupTopic;
import com.storyhasyou.example.cloud.topic.MyTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author fangxi
 * @date 2020/4/6
 */
@EnableBinding({Sink.class, MyTopic.class, GroupTopic.class})
@SpringBootApplication
public class StreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamApplication.class, args);
    }

}
