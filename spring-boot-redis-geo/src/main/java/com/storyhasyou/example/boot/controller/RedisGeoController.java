package com.storyhasyou.example.boot.controller;

import com.storyhasyou.example.boot.dto.AddGeoDTO;
import com.storyhasyou.example.boot.service.RedisGeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author fangxi
 * @date 2020/5/18
 * @since 1.0.0
 */
@RestController
@RequestMapping("/redis/geo")
public class RedisGeoController {

    @Autowired
    private RedisGeoService redisGeoService;

    @PostMapping("/add")
    public ResponseEntity<Void> addGeo(@RequestBody AddGeoDTO addGeoDTO) {
        redisGeoService.addGeo(addGeoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/{member}")
    public ResponseEntity<Void> removeGeo(@PathVariable String member) {
        redisGeoService.removeGeo(member);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/location")
    public ResponseEntity<Void> getLocation(@RequestParam String member1, @RequestParam String member2) {
        redisGeoService.getLocation(member1, member2);
        return ResponseEntity.ok().build();
    }


}
