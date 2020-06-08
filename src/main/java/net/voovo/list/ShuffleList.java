package net.voovo.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 打乱list
 * Collections.shuffle
 * @Author yml
 * @Date 2020/5/12
 */
public class ShuffleList {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        System.out.println(list);
    }
}
