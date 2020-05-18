package com.storyhasyou.example.boot.service.impl;

import com.storyhasyou.example.boot.dto.AddGeoDTO;
import com.storyhasyou.example.boot.service.RedisGeoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author fangxi
 * @date 2020/5/18
 * @since 1.0.0
 */
@Slf4j
@Service
public class RedisGeoServiceImpl implements RedisGeoService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY = "locations";

    @Override
    public void addGeo(AddGeoDTO addGeoDTO) {
        Point point = new Point(Double.parseDouble(addGeoDTO.getLongitude()), Double.parseDouble(addGeoDTO.getLatitude()));
        RedisGeoCommands.GeoLocation<String> geoLocation = new RedisGeoCommands.GeoLocation<>(addGeoDTO.getMember(), point);
        redisTemplate.opsForGeo().add(KEY, geoLocation);
    }

    @Override
    public void removeGeo(String member) {
        redisTemplate.opsForGeo().remove(KEY, member);
    }

    @Override
    public void getLocation(String member1, String member2) {
        GeoOperations<String, String> geoOperations = redisTemplate.opsForGeo();
        // 查找位置
        List<Point> position = geoOperations.position(KEY, member1, member2);
        position.forEach(point -> log.info("point: {}", point));

        // 5公里内
        Point center = new Point(120.355821, 31.556381);
        Circle circle = new Circle(center, new Distance(10, Metrics.KILOMETERS));
        GeoResults<RedisGeoCommands.GeoLocation<String>> radius = geoOperations.radius(KEY, circle);
        log.info("radius: {}", radius);

        // 查看member1 和member2 的距离
        Distance distance = geoOperations.distance(KEY, member1, member2, Metrics.KILOMETERS);
        log.info("member1和member2的距离: {}", distance);
    }
}
