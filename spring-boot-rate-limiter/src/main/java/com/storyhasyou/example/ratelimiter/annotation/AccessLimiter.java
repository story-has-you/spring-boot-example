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

    String methodKey() default "";

    int limit() default 10;

    TimeUnit unit() default TimeUnit.SECONDS;

    long timeout() default 1;


}
