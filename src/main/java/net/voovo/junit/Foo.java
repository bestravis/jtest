package net.voovo.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * JUnit 练习
 */
public class Foo {

    @ParameterizedTest
    @CsvSource({"1","0"})
    public void test(int i){
        assert (i==1);
    }
}
