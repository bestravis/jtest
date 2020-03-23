package oo;

/**
 * @Author: yml
 * @Date: 2020/3/23 16:25
 */
public class ValueWithPoint {

    public static void main(String[] args) {
        Integer i1=127;
        Integer i2=127;
        System.err.println(i1 == i2);//true
        i1=128;
        i2=128;
        System.err.println(i1 == i2);//false
        /**关键在于127属于byte，Integer可以指向不用创建内存空间？？**/
    }
}
