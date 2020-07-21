package net.voovo.concurrency;

import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * guava 字符串锁，适用于单机内线程并发加锁
 * @Author yml
 * @Date 2020/6/30
 */
public class StringLock {

    private static final Interner<String> pool = Interners.newWeakInterner();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Runnable> list=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Runnable runnable = new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    synchronized (pool.intern("Order_" + 1)) {
                        System.out.println(new Date().getTime()+":"+Thread.currentThread().getName());
//						Thread.sleep(20);
                    }
                }
            };
            list.add(runnable);
        }
        new Thread(list.get(0)).start();
        new Thread(list.get(1)).start();
        new Thread(list.get(2)).start();
        new Thread(list.get(3)).start();
        new Thread(list.get(4)).start();
        new Thread(list.get(5)).start();
    }
}
