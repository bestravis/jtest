package net.voovo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Holder,用于java闭包中匿名内部类修改外部变量
 * @Author: yml
 * @Date: 2020/1/10 11:42
 */
public class Holder<T> {

    private T value;

    public Holder(){
    }

    public Holder(T value) {
        this.value = value;
    }

    public void value(T  value){
        this.value = value;
    }

    public T value(){
        return value;
    }

    public static void main(String[] args) {
        List list=Arrays.asList("a","b");
        int i=0;
        Holder<Integer> k=new Holder<Integer>();//通过Hold避开
        k.value(i);
        list.forEach(e->{
            //java不允许在匿名内部类里修改外部变量，多线程竞争，变量释放
            //i++;
            k.value(2);
        });
        System.out.println(k.value);
    }
}
