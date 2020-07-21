package net.voovo.xio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 文件流
 * @Author yml
 * @Date 2020/6/8
 */
public class FileStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream(new File("d:\\jsonFile.txt"));
        StringBuilder builder=new StringBuilder();
        byte[] buf=new byte[1024];
        int length=0;
        while((length=fis.read(buf))!=-1){
            builder.append(new String(buf,0,length));
        }
        System.out.println(builder);
    }
}
