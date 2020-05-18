package com.storyhasyou.example.boot.service;

import com.storyhasyou.example.boot.dto.AddGeoDTO;

/**
 * @author fangxi
 * @date 2020/5/18
 * @since 1.0.0
 */
public interface RedisGeoService {

    /**
     * 添加GEO信息
     */
    void addGeo(AddGeoDTO addGeoDTO);

    /**
     * 删除GEO信息
     *
     * @param member
     */
    void removeGeo(String member);

    /**
     * 获取两个member之间的距离
     *
     * @param member1
     * @param member2
     * @return
     */
    void getLocation(String member1, String member2);


}
