package com.storyhasyou.example.boot.execute;

import com.storyhasyou.example.boot.dto.MessageBuilder;
import com.storyhasyou.example.boot.dto.MessageDTO;
import com.storyhasyou.example.boot.dto.Result;
import com.storyhasyou.example.boot.scanner.Invoker;
import com.storyhasyou.example.boot.scanner.InvokerCache;
import io.netty.channel.ChannelHandlerContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fangxi created by 2020/5/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest implements Runnable {

    private MessageDTO.Message message;
    private ChannelHandlerContext ctx;

    @Override
    public void run() {
        String module = message.getModule();
        String cmd = message.getCmd();
        Invoker invoker = InvokerCache.get(module, cmd);
        byte[] data = message.getBody().toByteArray();
        Result<?> result = (Result<?>) invoker.invoke(data);
        ctx.writeAndFlush(MessageBuilder.getResponseMessage(module, cmd, result.getResultType(), result.getData()));
    }
}
