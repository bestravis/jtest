package net.voovo.thread.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

    public static void main(String[] args) throws InterruptedException {
        long multiTime=System.currentTimeMillis();
        long singleTime;
        ExecutorService executorService=Executors.newFixedThreadPool(10);
        int paperSize=1000;
        for (int i = 0; i < paperSize; i++) {
            executorService.execute(new PrinterRunnable(i));
            if(i==paperSize-1){
                executorService.shutdown();
            }
        }
        while (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("working..");
        }
        multiTime=System.currentTimeMillis()-multiTime;



        singleTime=System.currentTimeMillis();
        for (int i = 0; i < paperSize; i++) {
            System.out.println(Thread.currentThread().getName()+" printer"+i+" "+System.currentTimeMillis());
            Thread.sleep(2);//耗时操作
        }
        System.out.println("多线程耗时："+multiTime);
        System.out.println("单线程耗时："+(System.currentTimeMillis()-singleTime));
        System.out.println("done..");
    }
}
