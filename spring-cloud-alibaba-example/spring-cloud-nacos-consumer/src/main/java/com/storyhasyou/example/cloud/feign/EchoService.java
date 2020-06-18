package com.storyhasyou.example.cloud.feign;

import com.storyhasyou.example.cloud.feign.callback.EchoServiceCallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author fangxi created by 2020/6/17
 */
@FeignClient(value = "service-provider", fallbackFactory = EchoServiceCallback.class)
public interface EchoService {

    @GetMapping(value = "/echo/{string}")
    String echo(@PathVariable("string") String string);
}
