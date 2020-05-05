package com.hubox.demo.netty.chapter2.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * TODO
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/5/5 21:26
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage " + EchoServer.class.getSimpleName() + " <port> !");
            return;
        }
        int port = Integer.parseInt(args[0]);
        //启动服务器
        new EchoServer(port).start();
    }

    /**
     * 启动服务器
     *
     * @return void
     * @author HUZHAOYANG
     * @date 2020/5/5 21:30
     **/
    public void start() throws Exception {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group)
                     .channel(NioServerSocketChannel.class)
                     .localAddress(new InetSocketAddress(port))
                     .childHandler(new ChannelInitializer<SocketChannel>() {
                         @Override
                         protected void initChannel(SocketChannel ch) {
                             ch.pipeline().addLast(serverHandler);
                         }
                     });
            ChannelFuture channelFuture = bootstrap.bind().sync();
            System.out.println("EchoServer started at port: " + port);
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
