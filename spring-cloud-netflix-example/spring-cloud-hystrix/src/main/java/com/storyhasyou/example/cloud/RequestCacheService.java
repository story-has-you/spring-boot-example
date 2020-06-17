package com.storyhasyou.example.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author fangxi
 * @date 2020/3/15
 */
@Service
public class RequestCacheService {

    @Autowired
    private IService service;

    @CacheResult
    @HystrixCommand(commandKey = "cacheKey")
    public Map<String, Object> cache(@CacheKey String name) {
        return service.cache();
    }
}
