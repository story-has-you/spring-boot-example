package com.storyhasyou.example.ratelimiter.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @author fangxi
 * @date 2020/2/29
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLimiter {

    /**
     * 限流方法,redis中的key
     */
    String methodKey() default "";

    /**
     * 单位时间内允许的请求
     */
    int limit() default 10;

    /**
     * 时间单位
     */
    TimeUnit unit() default TimeUnit.SECONDS;

    /**
     * 时间
     */
    long timeout() default 1;

}
