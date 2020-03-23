package net.voovo.concurrency;

import net.voovo.util.LoggerUtils;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @Author: yml
 * @Date: 2020/3/23 15:25
 */
public class StaticTest {

    static int num=0;

    public static void main(String[] args) {
        //阿里建议不要手动创建容易oom
        //ExecutorService threadPool = Executors.newFixedThreadPool(20);

        ScheduledExecutorService service=
                new ScheduledThreadPoolExecutor(10,new BasicThreadFactory.Builder().namingPattern("ScheduledExecutor-Thread-%d").daemon(true).build());
        LoggerUtils.info(""+num);
        StaticTest foo=new StaticTest();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                foo.print2();
            }).start();
        }

    }

    public static synchronized void print(){
        ++StaticTest.num;
        LoggerUtils.info(""+num);
    }

    //需要通过实例来访问 TODO 加了static有什么区别
    public synchronized void print2(){
        ++StaticTest.num;
        LoggerUtils.info(""+num);
    }
}
