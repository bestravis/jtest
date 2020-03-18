package net.voovo.thread.cyclicBarrier;

import net.voovo.util.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: yml
 * @Date: 2020/3/18 9:04
 */
public class Test {

    private static Logger logger = LoggerFactory.getLogger("Test");
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        final CyclicBarrier barrier=new CyclicBarrier(5);
        logger.info("aa");
        for (int j = 0; j < 4; j++) {
            new Thread(()->{
                for (int i = 0; i < 3; i++) {
                    LoggerUtils.info(Test.class,i+"");
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
        System.out.println("done");
    }
}
