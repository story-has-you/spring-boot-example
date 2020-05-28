package com.storyhasyou.example.boot.marshalling;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author fangxi
 * @date 2020/5/28
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
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

    }

}
