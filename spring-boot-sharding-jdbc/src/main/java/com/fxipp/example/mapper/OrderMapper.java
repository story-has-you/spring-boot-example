package com.fxipp.example.mapper;

import com.fxipp.example.entity.Order;

import java.util.List;

/**
 * @author fangxi
 * @date 2020/2/24
 */
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> list();

}
