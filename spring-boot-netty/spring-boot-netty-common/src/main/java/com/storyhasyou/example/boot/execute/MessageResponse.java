package com.storyhasyou.example.boot.execute;

import com.storyhasyou.example.boot.dto.MessageDTO;
import io.netty.channel.ChannelHandlerContext;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author fangxi created by 2020/6/3
 */
@Data
@AllArgsConstructor
public class MessageResponse implements Runnable {

    private MessageDTO.Message message;
    private ChannelHandlerContext ctx;

    @Override
    public void run() {

    }
}
