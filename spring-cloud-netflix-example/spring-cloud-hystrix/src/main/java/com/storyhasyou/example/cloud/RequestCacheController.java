package com.storyhasyou.example.cloud;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author fangxi
 * @date 2020/3/15
 */
@RequestMapping("/cache")
@RestController
public class RequestCacheController {

    @Autowired
    private RequestCacheService requestCacheService;

    @GetMapping
    public Map<String, Object> cache() {
        // @Cleanup 自动调用close方法
        @Cleanup HystrixRequestContext hystrixRequestContext =  HystrixRequestContext.initializeContext();
        // 调用加上 @CacheResult 注解的方法,并且在HystrixRequestContext.initializeContext()同一个方法里,缓存才会生效
        requestCacheService.cache("name");
        requestCacheService.cache("name");
        return requestCacheService.cache("name");

    }

}
