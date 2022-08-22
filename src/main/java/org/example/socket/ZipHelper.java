package org.example.socket;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;

/**
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2022/8/19 13:01
 */
public class ZipHelper {

    private static String ZIP_STREAM_HEADER = "__zip_";
    private static byte[] zipStreamHeader = ZIP_STREAM_HEADER.getBytes();


    /**
     * 解压GZip
     * @param input
     * @return
     */
    public static byte[] unGZip(byte[] input) {
        if(!HasZip(input))
            return input;
        byte[] data = new byte[input.length - 4 - zipStreamHeader.length];
        for (int i = zipStreamHeader.length+4;i < input.length;i++) {
            data[i-zipStreamHeader.length-4] = input[i];
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int buffSize = 512;
            ByteArrayInputStream bis  = new ByteArrayInputStream(data);
            GZIPInputStream gzip = new GZIPInputStream(bis,buffSize);
            byte[]               buf  = new byte[buffSize];
            int num;

            while ((num = gzip.read(buf, 0, buf.length)) != -1) {
                baos.write(buf, 0, num);
            }

            gzip.close();
            bis.close();

            baos.flush();
            baos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return baos.toByteArray();
    }


    /**
     * 判断一个字节数组是否是压缩字节数组
     * @param input
     * @return
     */
    public static boolean HasZip(byte[] input) {
        if (input.length < zipStreamHeader.length){
            return false;
        }
        String header = null;
        try {
            header = new String(input, 0, zipStreamHeader.length, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return header.equals(ZIP_STREAM_HEADER);
    }
}
