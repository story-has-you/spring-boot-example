package com.storyhasyou.example.boot.marshalling;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fangxi
 * @date 2020/5/28
 * @since 1.0.0
 */
@Data
public class ResponseData implements Serializable {

    private String id;
    private String name;
    private String message;


}
