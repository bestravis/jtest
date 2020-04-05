package algorithm.sort.bubble;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 14, 5, 5, 6, 8};
        int pot = 0;
        //冒泡
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    pot = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = pot;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
