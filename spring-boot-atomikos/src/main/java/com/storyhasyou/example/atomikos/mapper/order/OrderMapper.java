package com.storyhasyou.example.atomikos.mapper.order;

import com.storyhasyou.example.atomikos.entity.Order;
import org.apache.ibatis.annotations.Mapper;

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
