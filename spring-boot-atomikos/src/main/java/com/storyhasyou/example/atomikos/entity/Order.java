package com.storyhasyou.example.atomikos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;

    private BigDecimal totalAmout;

    private Integer status;

    private Long userId;
}
