package com.storyhasyou.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author fangxi created by 2020/8/3
 */
@SpringBootApplication
public class ConnectionPoolApplication {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(ConnectionPoolApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() throws Exception {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from ums_user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            System.out.println(username);
        }
    }

}