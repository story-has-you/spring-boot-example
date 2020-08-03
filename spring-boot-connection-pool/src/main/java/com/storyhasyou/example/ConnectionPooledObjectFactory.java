package com.storyhasyou.example;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.sql.*;

/**
 * @author fangxi created by 2020/8/3
 */
public class ConnectionPooledObjectFactory implements PooledObjectFactory<Connection> {

    private String driverClassName = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/kuaiplay?useUnicode=true&characterEncoding=UTF-8&serverTimezone=CTT&useSSL=false";
    private String username = "root";
    private String password = "123456";


    @Override
    public PooledObject<Connection> makeObject() throws Exception {
        Class.forName(driverClassName);
        Connection connection = DriverManager.getConnection(url, username, password);
        return new DefaultPooledObject<>(connection);
    }

    @Override
    public void destroyObject(PooledObject<Connection> pooledObject) throws Exception {
        pooledObject.getObject().close();
    }

    @Override
    public boolean validateObject(PooledObject<Connection> pooledObject) {
        Connection connection = pooledObject.getObject();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            int i = resultSet.getInt(1);
            return i == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public void activateObject(PooledObject<Connection> pooledObject) throws Exception {
        // 可以把额外的配置放在这里
    }

    @Override
    public void passivateObject(PooledObject<Connection> pooledObject) throws Exception {

    }
}
