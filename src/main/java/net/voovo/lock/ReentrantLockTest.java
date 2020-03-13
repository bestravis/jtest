package net.voovo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁 ReentrantLock
 * @Author: yml
 * @Date: 2020/3/12 15:44
 */
public class ReentrantLockTest {

    private static final Lock lock=new ReentrantLock();

    public static void test(){
        //将lock放在异常捕获之外，防止加锁代码前的代码出现异常，finally解锁一个没有加锁的对象
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"：获得了锁");
            //do something
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁应该位于finally代码块的第一行
            System.out.println(Thread.currentThread().getName()+"：释放了锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(()->test(),"thread a").start();
        new Thread(()->test(),"thread b").start();
        new Thread(()->test(),"thread c").start();
    }
}
