package com.hubox.demo.netty.chapter6;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * SimpleChannelInboundHandler 会自动释放资源
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/5/6 22:15
 */
public class SimpleDiscardHandler extends SimpleChannelInboundHandler<Object> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        //...no need to do anything special
    }
}
