package oo;

import org.junit.jupiter.api.Test;

public class FinallyTest {

    public static int foo(){
        int i=0;
        try {
            ++i;
        }finally {
            ++i;
        }
        return ++i;
    }

    @Test
    public void test(){
        System.out.println(foo());
    }
}
