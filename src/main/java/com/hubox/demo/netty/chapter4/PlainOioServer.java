package com.hubox.demo.netty.chapter4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * 使用java OIO的网络编程
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/5/6 8:09
 */
public class PlainOioServer {

    private final int port;

    public PlainOioServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage " + PlainOioServer.class.getSimpleName() + " <port> !");
            return;
        }
        int port = Integer.parseInt(args[0]);
        new PlainOioServer(port).server();
    }

    public void server() throws IOException {
        final ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port: " + port);
        try {
            for (; ; ) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connect: " + clientSocket.getReuseAddress());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream out;
                        try {
                            out = clientSocket.getOutputStream();
                            out.write("Hi! \r\n".getBytes(Charset.forName("UTF-8")));
                            out.flush();
                            clientSocket.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } finally {
                            try {
                                clientSocket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
