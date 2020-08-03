package com.storyhasyou.example;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fangxi created by 2020/8/3
 * 可以用 /actuator/datasource访问到这个方法
 */
@Endpoint(id = "datasource")
public class DataSourceEndpoint {

    private StoryDataSource dataSource;

    public DataSourceEndpoint(StoryDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 用get方法访问的时候调用
     * @return
     */
    @ReadOperation
    public Map<String, Object> pool() {
        GenericObjectPool<Connection> objectPool = dataSource.getPool();
        Map<String, Object> result = new HashMap<>();
        result.put("numActive", objectPool.getNumActive());
        result.put("numIdle", objectPool.getNumIdle());
        result.put("createdCount", objectPool.getCreatedCount());
        return result;
    }

}
