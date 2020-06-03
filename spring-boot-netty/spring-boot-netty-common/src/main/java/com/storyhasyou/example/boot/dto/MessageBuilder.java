package com.storyhasyou.example.boot.dto;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageV3;

/**
 * @author fangxi created by 2020/6/3
 * 创建请求和回送相应的数据封装类
 */
public class MessageBuilder {


    private static final long crCode = 0xabef0101;

    public static MessageDTO.Message getResponseMessage(String module, String cmd, MessageDTO.ResultType resultType, GeneratedMessageV3 data) {
        return MessageDTO.Message.newBuilder()
                .setMessageType(MessageDTO.MessageType.RESPONSE)
                .setCrcCode(crCode)
                .setModule(module)
                .setCmd(cmd)
                .setResultType(resultType)
                .setBody(ByteString.copyFrom(data.toByteArray()))
                .build();
    }

    public static MessageDTO.Message getRequestMessage(String module, String cmd,GeneratedMessageV3 data) {
        return MessageDTO.Message.newBuilder()
                .setMessageType(MessageDTO.MessageType.REQUEST)
                .setCrcCode(crCode)
                .setModule(module)
                .setCmd(cmd)
                .setResultType(MessageDTO.ResultType.SUCCESS)
                .setBody(ByteString.copyFrom(data.toByteArray()))
                .build();
    }
}
