package oo;

public class ConstructTest {
    public static void main(String[] args) {
        Boo boo=new Biz();
        System.out.println("---");
        boo=new Biz();
    }
}

/**
 * 首次初始化子类，1.执行父类static块，再执行子类static块  2.执行父类默认构造方法，再执行子类构造方法
 * 其后new 子类的实例，先执行父类默认构造方法，再执行子类构造方法
 * static块只执行一次，static优先于构造方法
 *
 * 父类先于子类
 * 静态块先于构造方法
 * 若类的静态块已执行过，则不再执行
 */
class Boo{
    static {
        System.out.println(1);
    }

    public Boo() {
        System.out.println(2);
    }

    static {
        System.out.println(3);
    }
}

class Biz extends Boo {
    static {
        System.out.println("a");
    }

    public Biz() {
        System.out.println("b");
    }
}
