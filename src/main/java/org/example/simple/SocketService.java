package org.example.simple;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2022/8/22 22:22
 */
public class SocketService {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5208);
        System.out.println("服务器启动成功");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("上线通知： " + socket.getInetAddress() + ":" + socket.getPort());
            new Thread(new ServerTask(socket)).start();
        }

    }
}
