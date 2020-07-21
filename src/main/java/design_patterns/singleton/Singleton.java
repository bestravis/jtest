package design_patterns.singleton;

/**
 * 通过classloader来实现线程安全且可懒初始化的单例
 */
public class Singleton {
    private static class SingletonHolder {  
        private static final Singleton INSTANCE = new Singleton();
    }  
    private Singleton (){}  
    public static final Singleton getInstance() {  
        return SingletonHolder.INSTANCE;
    }  
}