package com.storyhasyou.example.cloud;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author fangxi
 * @date 2020/3/15
 */
@Slf4j
@Component
public class ServiceFallbackFactory implements FallbackFactory<IService> {
    @Override
    public IService create(Throwable throwable) {
        log.error("", throwable);
        return new IService() {
            @Override
            public String error(Integer num) {
                log.error("num: {}", num);
                return "error出错啦!!!";
            }

            @Override
            public String retry(Long timeout) {
                log.error("timeout: {}", timeout);
                return "retry出错啦!!!";
            }
        };
    }
}
