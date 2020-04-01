package oo;

public class StringTest {

    public static void main(String[] args) {
        String str="hello";
        String str2="he"+new String("llo");
        System.err.println(str==str2);//false
    }
}
