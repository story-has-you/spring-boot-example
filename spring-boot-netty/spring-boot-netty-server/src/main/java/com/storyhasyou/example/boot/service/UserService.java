package com.storyhasyou.example.boot.service;

import com.storyhasyou.example.boot.annotion.Cmd;
import com.storyhasyou.example.boot.annotion.Module;
import com.storyhasyou.example.boot.dto.Result;
import com.storyhasyou.example.boot.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author fangxi created by 2020/5/30
 */
@Slf4j
@Service
@Module("user")
public class UserService {

    @Cmd("save")
    public Result<?> save(UserDTO.User user) {
        // save逻辑
        log.info("user...save, {}", user);
        return Result.ok();
    }

    @Cmd("update")
    public void update() {
        log.info("user...update");
    }

}
