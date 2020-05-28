package com.storyhasyou.example.boot.marshalling;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fangxi
 * @date 2020/5/28
 * @since 1.0.0
 */
@Slf4j
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 接受相应
        try {
            ResponseData responseData = (ResponseData) msg;
            log.info("responseData: {}", responseData);
        } finally {
            ReferenceCountUtil.release(ctx);
        }
    }
}
