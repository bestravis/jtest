package net.voovo.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yml
 * @Date 2020/5/12
 */
public class SubList {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        list=list.subList(0,5);
        System.out.println(list);
        System.out.println(list.size());
    }
}
