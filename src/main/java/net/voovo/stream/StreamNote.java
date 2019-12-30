package net.voovo.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 生成流的途径
 *
 * 创建流-中间操作-终止
 * @Author: yml
 * @Date: 2019/12/30 17:17
 */
public class StreamNote {

    @Test
    public void test(){
        /*
        * 1.可以通过Collection系列集合提供的 stream()或者parallelStream()
        * */
        List<String> list=new ArrayList<>();
        Stream<String> stream1=list.stream();

        /*
        * 2.通过Arrays中的静态方法stream()获取数组流
        * */
        String[] strings=new String[]{};
        Stream<String> stream2= Arrays.stream(strings);

        /*
        * 3.通过Stream中的静态方法 of()
        * */
        Stream<String> stream3 = Stream.of("1", "2");

        /*
        * 4.创建无限流
        * */
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(4).forEach(System.out::println);

        //生成
        Stream.generate(()->Math.random())
                .limit(5)
                .forEach(System.out::println);
    }
}
