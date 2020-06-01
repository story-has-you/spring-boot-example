package com.storyhasyou.example.boot;

import com.storyhasyou.example.boot.dto.MessageDTO;
import com.storyhasyou.example.boot.execute.MessageRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fangxi created by 2020/5/30
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    private final ThreadPoolExecutor workerPool = new ThreadPoolExecutor(5,
            10,
            60L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(256),
            new ThreadPoolExecutor.DiscardPolicy()
    );

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MessageDTO.Message request = (MessageDTO.Message) msg;
        workerPool.submit(new MessageRequest(request, ctx));
    }
}
