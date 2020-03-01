package net.voovo.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i< 60; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //多线程下懒汉模式会有问题
                    System.out.println(Thread.currentThread().getName()+":"+Cat.getInstance());
                }
            });
        }
        threadPool.shutdown();
    }
}

class Cat{
    private static Cat instance;
    Cat(){}

    public static Cat getInstance(){
        if(instance ==null){
            instance =new Cat();
        }
        return instance;
    }
}
