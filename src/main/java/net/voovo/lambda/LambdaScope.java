package net.voovo.lambda;

import net.voovo.pojo.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * lambda作用域
 *
 * @Author: yml
 * @Date: 2019/12/31 14:18
 */
public class LambdaScope {

    //实例变量
    int k=9;

    /*
    * 在Lambda表达式里面修改外部变量的值是可以的，可以将变量定义为实例变量或者将变量定义为数组
    * */
    @Test
    public void test(){
        User[] user=new User[]{new User(2,"chan"),null};
        int[] arr=new int[]{1,2};
        int b;
        Arrays.asList("a").forEach(e->{
            //b=2; //此处报错，lambda中不允许修改外部变量
            k=7;
            user[1]=new User(1,"lee");
            arr[1]=3;//？？？
            System.out.println("数组："+Arrays.toString(arr));
            System.out.println("数组："+Arrays.toString(user));
            System.out.println("实例变量："+k);
        });

    }
}
