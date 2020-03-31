package com.storyhasyou.example.boot.mapper.user;

import com.storyhasyou.example.boot.entity.User;

/**
 * @author fangxi
 * @date 2020/2/28
 */
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
