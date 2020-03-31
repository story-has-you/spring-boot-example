package com.storyhasyou.example.boot.repository;

import com.storyhasyou.example.boot.entity.PayMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Repository
public interface PayMsgRepository extends JpaRepository<PayMsg, Long>, JpaSpecificationExecutor<PayMsg> {

    List<PayMsg> findByStatus(Integer status);

}
