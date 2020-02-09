package net.voovo.array;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Spliterator;

/**
 * @Author: yml
 * @Date: 2020/1/15 20:30
 */
public class IntArray2String {

    public static void main(String[] args) {
        Integer[] english = new Integer[]{603,607,604,605,608,609};
        String s = Arrays.toString(english).replace(" ", "");
        System.out.println(s.substring(1,s.length()-1 ));

        System.out.println(Arrays.asList("1,2"));

    }
}
