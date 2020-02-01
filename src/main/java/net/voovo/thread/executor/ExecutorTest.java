package net.voovo.thread.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        int paperSize=10000;
        for (int i = 0; i < paperSize; i++) {
            executorService.execute(new PrinterRunnable(i));
            if(i==paperSize-1){
                executorService.shutdown();
            }
        }
        while (!executorService.awaitTermination(100, TimeUnit.SECONDS)) {
            System.out.println("working..");
        }
        System.out.println("done..");
    }
}
