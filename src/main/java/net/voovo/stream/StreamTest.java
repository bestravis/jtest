package net.voovo.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: yml
 * @Date: 2019/12/30 17:01
 */
public class StreamTest {

    public static void main(String[] args) {
        List list= Arrays.asList("aa","bb","cc");
        int a;

        Stream.of(list);
    }
}
