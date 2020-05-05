package com.hubox.demo.netty.chapter2.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * TODO
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/5/5 21:54
 */
public class EchoClient {

    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage " + EchoClient.class.getSimpleName() + " <host> <port>!");
            return;
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        new EchoClient(host, port).start();
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                     .remoteAddress(host, port)
                     .handler(new ChannelInitializer<SocketChannel>() {
                         @Override
                         protected void initChannel(SocketChannel ch) {
                             ch.pipeline().addLast(new EchoClientHandler());
                         }
                     });
            ChannelFuture future = bootstrap.connect().sync();
            future.channel().closeFuture().sync();//阻塞，直到Channel被关闭。EchoServer返回消息后，会关闭Channel。
        } finally {
            group.shutdownGracefully().sync();
        }
    }

}
