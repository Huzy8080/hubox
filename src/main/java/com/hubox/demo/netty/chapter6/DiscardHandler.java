package com.hubox.demo.netty.chapter6;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * 重写channelRead()方法时，需要显示的释放资源
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/5/6 22:12
 */
@ChannelHandler.Sharable
public class DiscardHandler extends ChannelInboundHandlerAdapter {
    //入站之后，如果不将消息传递下一个ChannelHandler，那么应该要手动释放消息，否则会引起资源泄漏
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //丢弃已接收的消息
        ReferenceCountUtil.release(msg);
    }
}
