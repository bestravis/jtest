package net.voovo.atomic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author: yml
 * @Date: 2019/12/31 14:56
 */
public class MultiThreadRaceDemo {

    int count=100000;
    int num=0;//实例变量，可以给内部类访问

    /*线程竞争*/
    @Test
    public void unSafeRace(){

        new Thread(()-> {
            for (int i = 0; i <count ; i++)
                num++;
            System.out.println("a:"+num);
        }).start();

        new Thread(()-> {
            for (int i = 0; i <count ; i++)
                num++;
            System.out.println("b:"+num);
        }).start();

        System.out.println("c:"+num);
    }

    /*安全的线程竞争
	* 此处自选循环导致程序死循环 TODO
	*/
    @Test
    public void safeRace() {
        AtomicInteger num=new AtomicInteger(0);//性能差
        new Thread(()-> {
            for (int i = 0; i <count ; i++){
                num.incrementAndGet();
                if(num.intValue()==(count*2)){
                    System.out.println("done a "+num);
                }
            }
            System.out.println("a:"+num);
        }).start();

        new Thread(()-> {
            for (int i = 0; i <count ; i++){
                num.incrementAndGet();
                if(num.intValue()==(count*2)){
                    System.out.println("done b "+num);
                }
            }
            System.out.println("b:"+num);
        }).start();

        System.out.println("c:"+num);
    }

    /*安全的线程竞争2*/
    @Test
    public void safeRace2() {
        LongAdder num=new LongAdder();//性能比 atomic*类要好
        new Thread(()-> {
            for (int i = 0; i <count ; i++)
                num.increment();
            System.out.println("a:"+num);
        }).start();

        new Thread(()-> {
            for (int i = 0; i <count ; i++)
                num.increment();
            System.out.println("b:"+num);
        }).start();

        System.out.println("c:"+num);
    }
}
