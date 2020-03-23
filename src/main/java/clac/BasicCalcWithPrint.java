package clac;


import org.junit.jupiter.api.Test;

/**
 * @Author: yml
 * @Date: 2020/3/23 16:30
 */
public class BasicCalcWithPrint {

    //-=
    @Test
    public void test1(){
        //二进制导致浮点数失真 TODO
        System.out.println(12-11.9==0.1);

        /***
         * 解决方法
         * 1.用Decimal
         */
        double price;
        for (int i = 1; i <= 10; i++) {
            price=i/1000.0;
            System.out.println(0.2+0.4);
        }
    }

    // + - * /
    @Test
    public void test2(){
        int foo=10,bar=10;
        System.out.println("+ result :"+foo+bar);//字符串正常拼接

        //该行编译错误，表达式前半部分已经拼接成字符串了，后面用减号无法计算
//        System.out.println("- result :"+foo-bar);


        System.out.println("* result :"+foo*bar);//乘除法优先
        System.out.println("/ result :"+foo/bar);
    }
}
