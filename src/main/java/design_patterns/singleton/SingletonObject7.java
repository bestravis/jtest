package design_patterns.singleton;

/**
 * 通过枚举的方式
 */
public class SingletonObject7 {
    private SingletonObject7() {
    }

    /**
     * 枚举类型是线程安全的，并且只会装载一次
     * 加上private
     */
    private enum Singleton {
        INSTANCE;
        private final SingletonObject7 instance;

        Singleton() {
            instance = new SingletonObject7();
        }

        private SingletonObject7 getInstance() {
            return instance;
        }
    }

    public static SingletonObject7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
}