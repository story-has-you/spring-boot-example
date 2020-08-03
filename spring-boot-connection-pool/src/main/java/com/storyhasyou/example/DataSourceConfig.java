package com.storyhasyou.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author fangxi created by 2020/8/3
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        return new StoryDataSource();
    }

    @Bean
    public DataSourceEndpoint dataSourceEndpoint() {
        return new DataSourceEndpoint((StoryDataSource) dataSource());
    }

}
