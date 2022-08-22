package org.example.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2022/8/21 20:39
 */
public class IOUtil {


    private IOUtil(){}

    /**
     * 通用的关闭流接口
     * @param close
     */
    public static void close(Closeable close){
        if(close!=null){
            try {
                close.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
