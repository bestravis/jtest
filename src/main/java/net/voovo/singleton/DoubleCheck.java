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
