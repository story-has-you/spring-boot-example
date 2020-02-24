package com.fxipp.example.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author fangxi
 * @date 2020/2/24
 */
@Data
public class Order {
    private Long id;

    private BigDecimal totalAmout;

    private Integer status;

    private Long userId;
}
