package com.storyhasyou.example.ratelimiter.aspect;

import com.storyhasyou.example.ratelimiter.annotation.AccessLimiter;
import com.storyhasyou.example.ratelimiter.limiter.AccessLimiterHandler;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fangxi
 * @date 2020/2/29
 */
@Aspect
@Slf4j
@Component
public class AccessLimiterAspect {

    @Autowired
    private AccessLimiterHandler accessLimiterHandler;
    public static final String PREFIX = "rate:limiter:";

    @Before("@annotation(accessLimiter)")
    public void before(JoinPoint joinPoint, AccessLimiter accessLimiter) {
        String key = accessLimiter.methodKey();
        int limit = accessLimiter.limit();
        long timeout = accessLimiter.timeout();
        TimeUnit timeUnit = accessLimiter.unit();
        long pexpire = timeUnit.toMillis(timeout);
        if (StringUtils.isEmpty(key)) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            String name = signature.getName();
            Class<?>[] parameterTypes = signature.getParameterTypes();
            key = name + Stream.of(parameterTypes).map(Class::getName).collect(Collectors.joining(",", "(", ")"));
            // log.info("key = {}", key);
        }
        accessLimiterHandler.limitAccess(PREFIX + key, limit, pexpire);
    }
}
