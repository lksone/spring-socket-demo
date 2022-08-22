package org.example.middle;

import java.net.Socket;

/**
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2022/8/22 23:32
 */
public class SocketClient1 {


    public static void main(String args[])throws Exception{
        Socket socket = new Socket("127.0.0.1", 5208);
        System.out.println("恭喜你连接成功!");
        //开启；两个
        new Thread(new SocketThread1(socket)).start();
        new Thread(new SocketThread2(socket)).start();
    }

}
