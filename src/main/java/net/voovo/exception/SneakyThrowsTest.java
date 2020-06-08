package net.voovo.exception;

import lombok.SneakyThrows;

/**
 * 测试lombak的注解对抛出异常的影响
 * @Author yml
 * @Date 2020/5/11
 */
public class SneakyThrowsTest {

    public static void main(String[] args) {
        SneakyThrowsTest pot=new SneakyThrowsTest();
        pot.foo();
    }

    @SneakyThrows
    public Integer foo(){
        if(true){
            throw new Exception("error");
        }
        return 1;
    }
}
