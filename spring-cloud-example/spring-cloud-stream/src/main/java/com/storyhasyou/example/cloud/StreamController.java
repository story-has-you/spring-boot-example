package com.storyhasyou.example.cloud;

import com.storyhasyou.example.cloud.topic.MyTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangxi
 * @date 2020/4/6
 */
@Slf4j
@RestController
@RequestMapping("/stream")
public class StreamController {

    @Autowired
    private MyTopic myTopic;

    @GetMapping("/{body}")
    public ResponseEntity<Void> sendMessage(@PathVariable String body) {
        myTopic.output().send(MessageBuilder.withPayload(body).build());
        return ResponseEntity.ok().build();
    }

}
