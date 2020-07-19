package net.voovo.threadPool;


import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService pool= Executors.newFixedThreadPool(10);

        //创建一个线程里的任务队列，长度为20
        BlockingQueue<Runnable> queue=new ArrayBlockingQueue<Runnable>(20);
        //new ThreadPoolExecutor();


    }
}
