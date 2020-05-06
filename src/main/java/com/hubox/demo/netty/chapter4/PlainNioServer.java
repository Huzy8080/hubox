package com.hubox.demo.netty.chapter4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 使用java NIO的网络编程
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/5/6 8:19
 */
public class PlainNioServer {
    private final int port;

    public PlainNioServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage " + PlainOioServer.class.getSimpleName() + " <port> !");
            return;
        }
        int port = Integer.parseInt(args[0]);
        new PlainNioServer(port).server();
    }

    private void server() throws IOException {
        //绑定服务器到端口
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        ServerSocket socket = serverChannel.socket();
        socket.bind(new InetSocketAddress(port));
        //打开Selector,并注册到serverChannel上
        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer msg = ByteBuffer.wrap("Hi! \r\n".getBytes());
        for (; ; ) {
            try {
                selector.select();
            } catch (IOException ex) {
                ex.printStackTrace();
                break;
            }
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                try {


                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel client = channel.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate());
                        System.out.println("Accepted connection from " + client);
                    }
                    if (selectionKey.isWritable()) {
                        SocketChannel channel1 = (SocketChannel) selectionKey.channel();
                        ByteBuffer attachment = (ByteBuffer) selectionKey.attachment();
                        while (attachment.hasRemaining()) {
                            if (channel1.write(attachment) == 0) {
                                break;
                            }
                        }
                        channel1.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    selectionKey.cancel();
                    try {
                        selectionKey.channel().close();
                    } catch (IOException e) {
                        //....
                    }
                }
            }
        }
    }


}
