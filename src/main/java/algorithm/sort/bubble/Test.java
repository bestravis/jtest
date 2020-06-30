package algorithm.sort.bubble;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 14, 5, 5, 6, 8,123,1231,2,3};
        int pot = 0;
        //冒泡 O(n^2)
        for (int i = 1; i < arr.length; i++) {//控制比较次数 O(n)
            for (int j = 0; j < arr.length - i; j++) {//比较数据 O(n))
                if (arr[j] > arr[j + 1]) {
                    pot = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = pot;
                }
            }
        }
        System.out.println(bubbleSort(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static String bubbleSort(int[] array){
        int tmp;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length-i; j++) {
               if(array[j]>array[j+1]){
                   tmp=array[j];
                   array[j]=array[j+1];
                   array[j+1]=tmp;
               }
            }
        }
        return Arrays.toString(array);
    }
}
