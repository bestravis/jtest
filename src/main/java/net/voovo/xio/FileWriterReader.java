package net.voovo.xio;

import java.io.*;

/**
 * @Author yml
 * @Date 2020/6/8
 */
public class FileWriterReader {
    static FileWriter fw;
    static FileReader fr;

    static {
        try {
            fw = new FileWriter(new File("d:\\hello.txt"));
            fr = new FileReader(new File("d:\\hello.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        read();
        write("hello");
        read();
    }

    public static void write(String text) throws IOException {
        fw.write(text);
    }

    public static void read() throws IOException {
        System.out.println();
    }
}
