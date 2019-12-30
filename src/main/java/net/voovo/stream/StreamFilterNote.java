package net.voovo.stream;

import net.voovo.pojo.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * 筛选，切片，去重
 * @Author: yml
 * @Date: 2019/12/30 17:28
 */
public class StreamFilterNote {

    List<User> userList = Arrays.asList(
            new User(1, "赵"),
            new User(2, "钱"),
            new User(3, "孙"),
            new User(4, "李"),
            new User(4, "李2"),
            new User(5, "叶")
    );

    /*
    * 筛选与切片
    * filter-接收lambda从流重排除某些元素
    * */
    @Test
    public void test() {
        /*保留大于3的对象*/
        Stream<User> userStream = userList.stream()
                .filter(e -> e.getId() > 3);
        userStream.forEach(System.out::println);
    }

    /*
     * limit 截断
     * */
    @Test
    public void test2() {
        //取前两个
        userList.stream().limit(2)
                .forEach(System.out::println);
    }

    /*
     * skip 跳过
     * 与limit互补
     * */
    @Test
    public void test3() {
        //跳过前两个
        userList.stream().skip(2)
                .forEach(System.out::println);
    }

    /*
     * distinct 去重
     * 需要重写对象的hashcode和equls
     * */
    @Test
    public void test4() {
        //跳过前两个
        userList.stream().distinct()
                .forEach(System.out::println);
    }
}
