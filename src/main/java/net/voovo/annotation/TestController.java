package net.voovo.annotation;

public class TestController {

    @MyLog
    public void test(){

    }

    public static void main(String[] args) {
        new TestController().test();
    }
}
