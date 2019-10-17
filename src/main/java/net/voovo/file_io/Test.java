package net.voovo.file_io;

import java.io.File;

/**
 * @Author: yml
 * @Date: 2019/9/27 9:36
 */
public class Test {

    public static void main(String[] args) {
        File file=new File("E:\\环球世界音乐文化之旅\\环球世界音乐文化之旅");
        System.out.println(file.isDirectory());
    }
}
