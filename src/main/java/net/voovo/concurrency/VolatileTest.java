package net.voovo.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class VolatileTest {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier=new CyclicBarrier(3);
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    Foo.incr();
                }
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        barrier.await();
        System.out.println(Foo.vl);
    }
}

class Foo{
    volatile static int vl=0;
    /**
     * vl++是复合操作，在编译成字节码后，会变成三行指令
     * 1读取原值 2计算原值+1 3用结果替换原值
     * volatile 只保证第一个读的原子性，后面两个操作会受到其他线程的影响
     */
    public static void incr(){
        vl++;
    }
}

