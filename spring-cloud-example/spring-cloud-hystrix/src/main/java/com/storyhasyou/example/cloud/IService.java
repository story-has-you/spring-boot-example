package com.storyhasyou.example.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author fangxi
 * @date 2020/3/14
 */
@FeignClient(value = "eureka-client", path = "/client", fallbackFactory = ServiceFallbackFactory.class)
public interface IService {

    @GetMapping("/error/{num}")
    String error(@PathVariable("num") Integer num);

    @GetMapping("/retry")
    String retry(@RequestParam Long timeout);

    @GetMapping("/cache")
    Map<String, Object> cache();
}
