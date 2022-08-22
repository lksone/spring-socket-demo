package org.example.middle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * 為了寫
 *
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2022/8/22 23:33
 */
public class SocketThread1 implements Runnable {

    public Socket socket;

    public SocketThread1(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            //读到了写进去？
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            while (true) {
                String str = br.readLine();
                pw.println(str);
                pw.flush();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
