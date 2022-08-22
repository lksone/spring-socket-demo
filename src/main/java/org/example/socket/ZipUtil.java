package org.example.socket;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.jws.WebMethod;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2022/8/19 12:24
 */
public class ZipUtil {


    public static String compress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return "";
        }
        byte[] tArray;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        try {
            gzip.write(str.getBytes("UTF-8"));
            gzip.flush();
        } finally {
            gzip.close();
        }

        tArray = out.toByteArray();
        out.close();

        BASE64Encoder tBase64Encoder = new BASE64Encoder();
        return tBase64Encoder.encode(tArray);
    }


    public static String uncompress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return "";
        }

        BASE64Decoder tBase64Decoder = new BASE64Decoder();
        byte[] t = tBase64Decoder.decodeBuffer(str);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(t);
        GZIPInputStream gunzip = new GZIPInputStream(in);
        try {
            byte[] buffer = new byte[256];
            int n;
            while ((n = gunzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        }finally{
            gunzip.close();
        }
        in.close();
        out.close();

        return out.toString("UTF-8");
    }


    public static void main(String[] args) throws IOException {
        String str = "1fdsafds fdsafsda   我爱中国";
        String compress = compress(str);
        System.out.println(compress);
        System.out.println(uncompress(compress));


        String s = compress1(str);
        System.out.println(s);
        System.out.println(uncompress2(s));

        //System.out.println(uncompress2("H4sIAAAAAAAAAA=="));
        System.out.println(uncompress("H4sIAAAAAAAAAA=="));

    }


    public String SayHello(String name) throws Exception {

        String t = uncompress(name);
        return compress("解压：" + t);

    }

    @WebMethod(exclude = true)
    public static String compress1(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return "";
        }

        byte[] tArray;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        try {
            gzip.write(str.getBytes("UTF-8"));
            gzip.flush();
        } finally {
            gzip.close();
        }

        tArray = out.toByteArray();
        out.close();

        BASE64Encoder tBase64Encoder = new BASE64Encoder();
        return tBase64Encoder.encode(tArray);
    }

    public static String uncompress2(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return "";
        }

        BASE64Decoder tBase64Decoder = new BASE64Decoder();
        byte[] t = tBase64Decoder.decodeBuffer(str);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(t);
        GZIPInputStream gunzip = new GZIPInputStream(in);
        try {
            byte[] buffer = new byte[256];
            int n;
            while ((n = gunzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        }finally{
            gunzip.close();
        }
        in.close();
        out.close();

        return out.toString("UTF-8");
    }

}
