package com.storyhasyou.example.atomikos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;

    private String username;
}
