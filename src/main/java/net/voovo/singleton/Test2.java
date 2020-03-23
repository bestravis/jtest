package net.voovo.singleton;

import net.voovo.util.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: yml
 * @Date: 2020/3/23 16:55
 */
public class Test2 {

    static Logger logger = LoggerFactory.getLogger(Test2.class);

    public static Test2 instance=null;

    /**
     * 静态方法访问成员变量，它必须是静态的
     * 该方法在多线程下非幂等，多试几次
     * @return
     */
    public static Test2 getInstance(){
        if(instance==null){
            instance=new Test2();
        }
        return  instance;
    }

    //double check 解决饿汉单例的多线程问题， synchronized锁住了类
    public static Test2 getInstance2(){
        if(instance==null){
            synchronized (Test2.class){
                if (instance==null){
                    instance=new Test2();
                }
            }
        }
        return  instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                logger.info("object hash addr {}",Test2.getInstance2());
            }).start();
        }
    }

}
