package org.example.utils;

import java.io.Closeable;
import java.io.File;
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


    public static void method(){
        File file =new File("C:\\Users\\Administrator\\Desktop\\新建 DOCX 文档.docx.zip");
        File file1 = new File("b.docx");
        file1.delete();
        file.renameTo(file1);
    }


    public static void getFileName(){
        File file = new File("b.docx");
        System.out.println(file.getName());
        int las = file.getAbsolutePath().lastIndexOf("\\");
        System.out.println(file.getAbsolutePath().substring(0,las+1));

    }

    public static String getFileDir(File file){

        int las = file.getAbsolutePath().lastIndexOf("\\");
        System.out.println(file.getAbsolutePath().substring(0,las+1));

        return file.getAbsolutePath().substring(0,las+1);
    }

    public static void main(String[] args) throws IOException {
        File file = new File("b.docx");
        String substring = file.getName().substring(0, file.getName().length() - 5);
        String fileDir = getFileDir(file);
        File docx = File.createTempFile("temp", ".tmp", new File(fileDir));
        System.out.println(docx.getAbsolutePath());
    }
}
