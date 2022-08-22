package org.example.socket;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2022/8/18 23:11
 */
@Component
public class SocketStart {


    @PostConstruct
    public void start() throws IOException {
        ServerSocket ss = new ServerSocket(9100);
        while (true) {
            Socket sock = ss.accept();
            System.out.println("connected from " + sock.getRemoteSocketAddress());
            //   Thread t = new SocketServer(sock);
          //  t.start();
        }
    }
}
