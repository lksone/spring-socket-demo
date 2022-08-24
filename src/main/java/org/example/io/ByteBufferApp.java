package org.example.io;

import java.nio.ByteBuffer;

/**
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2022/8/18 22:57
 */
public class ByteBufferApp {

    public static void main(String[] args) {
        testByteBuffer();
    }


    /**
     * 测试使用ByteBuffer的缓存区
     */
    private static void testByteBuffer() {
        // 初始化一个大小为6的ByteBuffer

        //直接使用的
        ByteBuffer buffer = ByteBuffer.allocate(6);

        //直接使用对外内存，直接存入磁盘映射的方式
        ByteBuffer buffer1 = ByteBuffer.allocateDirect(1024);

        // 初始状态：position: 0, limit: 6, capacity: 6
        print(buffer);

        // 往buffer中写入3个字节的数据
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);
        // 写入之后的状态：position: 3, limit: 6, capacity: 6
        print(buffer);

        System.out.println("************** after flip **************");
        buffer.flip();
        // 切换为读取模式之后的状态：position: 0, limit: 3, capacity: 6
        print(buffer);

        buffer.get();
        buffer.get();
        // 读取两个数据之后的状态：position: 2, limit: 3, capacity: 6·
        print(buffer);
        buffer.flip();
        print(buffer);
    }

    private static void print(ByteBuffer buffer) {
        System.out.printf("position: %d, limit: %d, capacity: %d\n",
                buffer.position(), buffer.limit(), buffer.capacity());
    }
}
