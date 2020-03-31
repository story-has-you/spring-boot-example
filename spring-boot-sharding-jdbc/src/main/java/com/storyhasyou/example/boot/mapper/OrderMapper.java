package com.storyhasyou.example.boot.mapper;

import com.storyhasyou.example.boot.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author fangxi
 * @date 2020/2/24
 */
@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> list();

}
