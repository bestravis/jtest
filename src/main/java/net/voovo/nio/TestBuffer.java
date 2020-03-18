package net.voovo.nio;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * 1.缓冲区（Buffer）：在java nio中负责数据的存储，缓冲区就是数组，用于存储不同的数据
 *
 * 根据数据类型的不同（Boolean除外），提供了相应的数据类型缓冲区：
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一样，都是通过allocate（）获取缓冲区
 *
 * 2.缓冲区存储数据的两个核心方法：
 * put（）：存入数据到缓冲区
 * get（）：从缓冲区获得数据
 *
 * 4.缓冲区中的四个核心属性
 * capacity：容量，表示缓冲区中最大的数据存储量，声明后不能修改
 * limit：界限，表示缓冲区中可以操作数据的大小，（limit后面的数据不是进行读写）
 * position：位置，表示缓冲区中正在操作的数据的位置
 * mark:可以记录当前position的位置，后面可以用reset方法让position回到mark的位置
 *
 * 0<=mark<=position<=limit<=capacity
 *
 * 5.直接缓冲区和非直接缓冲区
 * 非直接缓冲区：通过allocate方法分配缓冲区，将缓冲区建立在jvm之上
 * 直接缓冲区：通过allocateDirect方法分配，将缓冲区建立在物理内存中，提高效率
 *
 * 非直接缓冲区在读取硬盘文件时，键盘》os内存》jvm内存》jvm， 两块内存需要同步，效率会比较低
 * 直接缓冲区是jvm直接在os内存中创建空间，jvm读写效率会比较高，风险是程序崩溃时，引用没有来得及删掉，会使os内存无法释放。存在风险。
 *
 * */
public class TestBuffer {

    @Test
    public void test(){
        //1.分配一个指定大小的缓冲区
        ByteBuffer buf=ByteBuffer.allocate(1024);
        System.out.println("---allocate---");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //2.用put方法把数据放入缓冲区
        //这里是写入模式
        buf.put("abcde".getBytes());
        System.out.println("---put---");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //3.切换到读取模式
        buf.flip();
        System.out.println("---flip---");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //4.利用get方法读取缓冲区中的数据
        byte[] dst=new byte[buf.limit()];
        buf.get(dst);
        System.out.println("buf get():"+new String(dst,0,dst.length));
        System.out.println("---get---");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //5.rewind
        //可以让position回到数组头部，buf可以重新从头读起
        buf.rewind();
        System.out.println("---rewind---");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //6.clear
        //数组的所有广播标记回到原点，答案是buf里的数据不会被清空
        buf.clear();
        System.out.println("---clear---");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        System.out.println((char) buf.get());
    }

    @Test
    public void test2(){
        String str="abdce";
        ByteBuffer buf=ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        //切换到读模式
        buf.flip();
        byte[] dst=new byte[buf.limit()];
        //读取两个到dst
        buf.get(dst,0,2);
        System.out.println(new String(dst,0,2));

        System.out.println(buf.position());
        //标记
        buf.mark();

        buf.get(dst,2,2);
        System.out.println(new String(dst,0,4));
        System.out.println(buf.position());

        buf.reset();
        System.out.println(buf.position());
    }

    @Test
    public void test3(){
        ByteBuffer buf=ByteBuffer.allocateDirect(1024);
        System.out.println("是否是直接缓冲区："+buf.isDirect());

    }
}
