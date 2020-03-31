package com.storyhasyou.example.boot.mapper.order;

import com.storyhasyou.example.boot.entity.Order;

/**
 * @author fangxi
 * @date 2020/2/28
 */
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}
