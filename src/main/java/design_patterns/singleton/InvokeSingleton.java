package design_patterns.singleton;

/**
 * 解决反射破坏单例
 */
public class InvokeSingleton {
    //classloader保证了线程安全创建实例
    private static InvokeSingleton singleton=new InvokeSingleton();
    //构造方法禁止new
    private InvokeSingleton(){
        //当通过反射调用时，如果实例已经存在抛异常。（反射是通过构造方法来创建对象的！！）
        if(singleton!=null){
            throw new RuntimeException("实例已存在，请通过getInstance方法调用");
        }
    }

    public InvokeSingleton getInstance(){
        return singleton;
    }
}
