package com.hubox.demo.netty.chapter6;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;

/**
 * 对于出站消息，如果要丢弃消息，则需要显式释放
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/5/6 22:25
 */
public class DiscardOutboundHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ReferenceCountUtil.release(msg);
        //让ChannelFutureListener收到消息已被处理的通知
        promise.setSuccess();
    }
}
