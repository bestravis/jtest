package net.voovo.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DoubleCheck {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i< 60; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+":"+Cat.getInstance());
                }
            });
        }
        threadPool.shutdown();
    }
}

class Dog{
    /**
     * 待验证，java并发编程艺术是这么说的
     * 此处还存在一个bug，在该变量还未初始化完时，其他线程读取，会获得一个非null的实例，但该实例还未初始化完毕
     * 加 volatile 可以解决  private static volatile Dog instance
     */
    private static Dog instance;
    Dog(){}

    public static Dog getInstance(){
        if(instance ==null){
            synchronized (Dog.class){
                if (instance ==null){
                    instance =new Dog();
                }
            }
        }
        return instance;
    }
}
