package org.example.middle;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2022/8/22 23:14
 */
public class SocketMiddleService {

    /**
     * 服务器存储多个数据信息
     */
    public static List<Socket> socketList = new ArrayList<Socket>();


    public static void main(String args[]) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5208);
        System.out.println("聊天室开启");
        while (true) {
            //从连接请求队列中取出一个连接，接收到多个不同的socket
            Socket socket = serverSocket.accept();
            System.out.println("上线通知： 用户" + socket.getPort() + "上线啦！");
            socketList.add(socket);
            new Thread(new ServerThread(socket)).start();
        }
    }
}
