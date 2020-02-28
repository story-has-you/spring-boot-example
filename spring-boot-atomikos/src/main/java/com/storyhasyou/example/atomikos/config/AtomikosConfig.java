package com.storyhasyou.example.atomikos.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.UserTransaction;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Configuration
public class AtomikosConfig {

    /**
     * 配置事物管理器
     */
    @Bean
    public JtaTransactionManager transactionManager() {
        UserTransaction transaction = new UserTransactionImp();
        UserTransactionManager transactionManager = new UserTransactionManager();
        return new JtaTransactionManager(transaction, transactionManager);
    }
}
