package com.storyhasyou.example.boot.repository;

import com.storyhasyou.example.boot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author fangxi
 * @date 2020/2/28
 */
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {

    Optional<Order> getByIdAndStatus(Long orderId, Integer status);

}
