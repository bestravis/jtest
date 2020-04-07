package algorithm.sort.merge;

import java.util.Arrays;

/**
 * 归并排序
 * 核心思想
 *
 * 分治：分而治之 分成多个子问题，对子问题进行求解
 * 递归：自己调用自己
 *
 * 空间换时间，一个优异的算法
 */
public class Test {

    public static void main(String[] args) {
        int[] data={1,412,4,123,1,23,43,5,6,66,871,10,1};
        mergeSort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));
    }

    public static void mergeSort(int[] data,int left,int right){
        //分治
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(data,left,mid);
            mergeSort(data,mid+1,right);
            //分完合并
            merge(data,left,mid,right);
        }
    }

    public static void merge(int[] data,int left,int mid,int right){
        int[] temp=new int[data.length];
        int point1=left;//表示左边的第一个数的位置
        int point2=mid+1;//表示右边的第一个数的位置

        int index=left;
        while (point1<=mid && point2<=right){
            if(data[point1]<=data[point2]){
                temp[index]=data[point1];
                point1++;
            }else {
                temp[index]=data[point2];
                point2++;
            }
            index++;
        }
        //合并的过程完了吗？还需要什么
        while (point1<=mid){
            temp[index++]=data[point1++];
        }
        while (point2<=right){
            temp[index++]=data[point2++];
        }
        for (int i = left; i <= right; i++) {
            data[i]=temp[i];
        }
    }
}
