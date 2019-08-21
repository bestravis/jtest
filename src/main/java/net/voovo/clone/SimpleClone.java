package net.voovo.clone;

class Address{
    String detail;
    public Address(String detail){
        this.detail=detail;
    }
}

class User implements Cloneable{

    int age;
    Address address;

    public User(int age){
        this.age=age;
        address=new Address("广东");
    }
    //调用super.clone()来实现克隆
    public User clone() throws CloneNotSupportedException{
        return (User)super.clone();
    }
}

/*浅克隆*/
public class SimpleClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        User a=new User(20);
        User b=a.clone();

        System.out.println(a==b);
        System.out.println(a.address==b.address);//浅克隆只克隆基本变量，引用变量指向的是同一个地方
    }
}
