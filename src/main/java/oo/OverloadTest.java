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
        foo.method(null);
        foo.method(new Object());
        //（Object，？）当两个方法都可以重载时，编译器会选择数值类型较为明确的那一个，编译正常
        //如果是两个普通的引用类型（String，Integer），会直接编译报错
    }
}
