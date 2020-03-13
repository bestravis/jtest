package net.voovo.annotation;

import java.util.Scanner;

public class TestController {

    @MyLog
    public void test(){

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num=2;
        while(true){
            String next = scan.next();
            if(next!=null){
                System.out.println(next+":1");
            }
        }

    }
}
