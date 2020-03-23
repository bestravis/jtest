package oo;

/**
 * @Author: yml
 * @Date: 2020/3/23 16:20
 */
public class Parent extends Base{

    public static void main(String[] args) {
        new Parent().method();
    }

    public void method(){
        System.out.println(super.getClass().getName());//oo.Parent
        System.out.println(this.getClass().getSuperclass().getName());//oo.Base
    }
}

class Base{}
