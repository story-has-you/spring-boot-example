package com.storyhasyou.example.boot.marshalling;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fangxi
 * @date 2020/5/28
 * @since 1.0.0
 */
@Slf4j
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object message) {
        RequestData requestData = (RequestData) message;
        log.info("requestData: {}", requestData);
        // 会写
        ResponseData responseData = new ResponseData();
        responseData.setId("response:" + requestData.getId());
        responseData.setName("response:" + requestData.getName());
        responseData.setMessage("response:" + requestData.getMessage());
        ctx.writeAndFlush(responseData);
    }
}
