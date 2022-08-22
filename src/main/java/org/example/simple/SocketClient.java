package org.example.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2022/8/22 22:31
 */
public class SocketClient {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 5208);
        System.out.println("小一连接成功");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        while (true) {
            pw.println("小一说：" + br.readLine());
            pw.flush();
        }
    }
}
