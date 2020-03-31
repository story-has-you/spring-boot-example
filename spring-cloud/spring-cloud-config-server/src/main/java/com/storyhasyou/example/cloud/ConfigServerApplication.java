package com.storyhasyou.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author fangxi
 * @date 2020/3/31
 * @since 1.0.0
 *
 * 启动之后访问 http://127.0.0.1:8888/config-server/dev 查看Server的信息
 *
 * http://127.0.0.1:8888/config-server-dev.yml 获取配置文件信息
 *
 * http://127.0.0.1:8888/{label}(默认master)/{配置文件名称}.yml
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
