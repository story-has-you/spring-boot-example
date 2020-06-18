package com.storyhasyou.example.cloud.feign.callback;

import com.storyhasyou.example.cloud.feign.EchoService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author fangxi created by 2020/6/18
 */
@Component
public class EchoServiceCallback implements FallbackFactory<EchoService> {

    @Override
    public EchoService create(Throwable throwable) {
        return string -> "callback hello";
    }
}
