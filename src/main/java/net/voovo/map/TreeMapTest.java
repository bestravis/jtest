package net.voovo.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<String, Object> map =new TreeMap<>();
        map.put("a","1");
        map.put("c","2");
        map.put("b","1");
        map.put("d","4");

        System.out.println(map);
    }
}
