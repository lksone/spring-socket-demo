package org.example.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2022/8/22 23:16
 */
public class ServerThread implements Runnable {


    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                //给说有的socket都发送消息
                for (Socket socket : SocketMiddleService.socketList) {
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                    printWriter.println("用户" + socket.getPort() + "说" + line);
                    printWriter.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
