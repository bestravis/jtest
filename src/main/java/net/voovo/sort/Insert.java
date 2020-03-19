package net.voovo.sort;

import net.voovo.util.LoggerUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: yml
 * @Date: 2020/3/18 17:00
 */
public class Insert {

    public static void main(String[] args) {
        StopWatch stopWatch=StopWatch.createStarted();

        int[] randomArray = getRandomArray(100000);
//        LoggerUtils.info(Arrays.toString(randomArray));
        stopWatch.stop();
        System.out.println(stopWatch.getTime());

        stopWatch.reset();
        stopWatch.start();
        int tmp;
        for (int i = 0; i < randomArray.length; i++) {
            tmp=randomArray[i];
            int index = i-1;
            for (;index >=0&& randomArray[index]>tmp; index--) {
                randomArray[index+1]=randomArray[index];

            }
            randomArray[index+1]=tmp;
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
//        LoggerUtils.info(Arrays.toString(randomArray));
    }

    static int[] getRandomArray(int size) {
        int[] arr = new int[size];
        Random random=new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000) + 1;
        }
        return arr;
    }
}
