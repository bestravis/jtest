package net.voovo.array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @Author: yml
 * @Date: 2020/3/20 18:09
 */
public class MergeArray {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,4};
        int[] arr2=new int[]{1,6,5};

        int[] pot=new int[arr.length+arr2.length];

        System.arraycopy(arr, 0, pot, 0, arr.length);
        System.arraycopy(arr2, 0, pot, arr.length, arr2.length);

        Arrays.sort(pot);

        System.out.println(Arrays.toString(pot));
        System.out.println(Arrays.toString(ArrayUtils.addAll(arr, arr2)));
    }
}
