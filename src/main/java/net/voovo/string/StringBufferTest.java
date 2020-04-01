package net.voovo.string;

public class StringBufferTest {

    public static void main(String[] args) {
        StringBuffer a=new StringBuffer("a");
        StringBuffer b=new StringBuffer("b");
        operat(a,b);
        System.out.println(a+","+b);
    }

    //只有通过append方法才能修改StringBuffer的值
    public static void operat(StringBuffer x,StringBuffer y){
        x.append(y);
        y=x;
    }
}
