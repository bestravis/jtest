package oo;

import net.voovo.thread.cyclicBarrier.Test;

/**
 * @Author: yml
 * @Date: 2020/3/23 16:37
 */
public class OverloadTest {

    public void method(Object object){
        System.out.println("object");
    }

    public void method(String string){
        System.out.println("string");
    }

    public static void main(String[] args) {
        OverloadTest foo=new OverloadTest();
        foo.method(null);//null为什么重载 TODO
        foo.method(new Object());//有new这个动作才会重载
    }
}
