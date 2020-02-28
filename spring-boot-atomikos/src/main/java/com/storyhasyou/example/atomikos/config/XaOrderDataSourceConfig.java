package com.storyhasyou.example.atomikos.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Configuration
@MapperScan(value = "com.storyhasyou.example.atomikos.mapper.order", sqlSessionFactoryRef = "sqlSessionFactoryBeanOrder")
public class XaOrderDataSourceConfig {

    @Bean
    public DataSource dataSourceXaOrder() {
        MysqlXADataSource dataSource = new MysqlXADataSource();
        dataSource.setUser("root");
        dataSource.setPassword("fx19950722");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/xa_order");
        AtomikosDataSourceBean dataSourceBean = new AtomikosDataSourceBean();
        dataSourceBean.setXaDataSource(dataSource);
        return dataSourceBean;
    }

    @Bean("sqlSessionFactoryBeanOrder")
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceXaOrder());
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("mapper/order/*.xml"));
        return sqlSessionFactoryBean;
    }

}
