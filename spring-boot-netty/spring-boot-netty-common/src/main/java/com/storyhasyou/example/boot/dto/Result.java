package com.storyhasyou.example.boot.dto;

import com.google.protobuf.GeneratedMessageV3;
import lombok.Data;

/**
 * @author fangxi created by 2020/5/30
 */
@Data
public class Result<T extends GeneratedMessageV3> {

    private MessageDTO.ResultType resultType;
    private T data;

    public static <T extends GeneratedMessageV3> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setResultType(MessageDTO.ResultType.SUCCESS);
        return result;
    }

    public static <T extends GeneratedMessageV3> Result<T> ok() {
        return ok(null);
    }



    public static <T extends GeneratedMessageV3> Result<T> error(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setResultType(MessageDTO.ResultType.FAILURE);
        return result;
    }

}
