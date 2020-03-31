package com.storyhasyou.example.cloud.config;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.storyhasyou.example.cloud.rules.ConsistentHashingRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fangxi
 * @date 2020/3/14
 * 指定服务配置负责均衡策略
 * RibbonClient
 */
@Configuration
@RibbonClient(name = "ribbon-example", configuration = ConsistentHashingRule.class)
public class RibbonRuleConfig {

    /**
     * 更改全局的负载均衡策略
     */
    @Bean
    public IRule rule() {
        // 指定为随机轮询.默认 RoundRobinRule
        return new BestAvailableRule();
    }

}
