package com.storyhasyou.example.boot;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author fangxi created by 2020/5/30
 */
@Slf4j
@Component
public class Client {

    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8765;
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    private EventLoopGroup eventLoopGroup = new NioEventLoopGroup(2);
    private Channel channel;

    public void connect(String host, int port) {
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {

                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            this.channel = channelFuture.channel();
            if (log.isDebugEnabled()) {
                log.debug("client start...");
            }
            this.channel.closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("client start fail ", e);
        } finally {
            // 所用资源释放完成之后，清空资源，再次发起重连操作
            executorService.execute(() -> this.connect(host, port));
        }
    }

}
