package net.voovo.clone;


import lombok.Data;
import lombok.ToString;

class Address{
    String detail;
    public Address(String detail){
        this.detail=detail;
    }
}

@ToString
@Data
class User implements Cloneable{

    int age;
    String memo;
    Address address;

    public User(int age,String memo){
        this.age=age;
        address=new Address("广东");
    }
    //调用super.clone()来实现克隆
    public User clone() throws CloneNotSupportedException{
        return (User)super.clone();
    }
}

/*浅克隆*/
//深克隆需要自己递归，处理那些引用型变量
//批量new对象有性能问题，可以使用clone来优化
public class SimpleClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        User a=new User(20,"tips");
        User b=a.clone();

        System.out.println(b);

        System.out.println(a==b);
        System.out.println(a.address==b.address);//浅克隆只克隆基本变量，引用变量指向的是同一个地方
    }
}
