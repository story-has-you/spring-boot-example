package com.storyhasyou.example.boot.marshalling;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.UUID;

/**
 * @author fangxi
 * @date 2020/5/28
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(MarshallingCodeCFactory.buildMarshallingDecoder())
                                .addLast(MarshallingCodeCFactory.buildMarshallingEncoder())
                                .addLast(new ClientHandler());

                    }
                });

        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8765).sync();
        Channel channel = channelFuture.channel();
        // 发送消息
        for (int i = 0; i < 10; i++) {
            RequestData requestData = new RequestData();
            requestData.setId(UUID.randomUUID().toString());
            requestData.setName("消息" + i);
            requestData.setMessage("内容" + i);
            channel.writeAndFlush(requestData);
        }

        channel.closeFuture().sync();
        workGroup.shutdownGracefully();

    }

}
