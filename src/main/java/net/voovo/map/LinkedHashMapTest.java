package net.voovo.map;

import java.util.Iterator;
import static java.util.Map.Entry;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: yml
 * @Date: 2020/3/23 13:43
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");
        System.out.println("开始时顺序：");
        Set<Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Entry<String, String>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
        System.out.println("通过get方法，导致key为name1对应的Entry到表尾");//accessOrder:true 导致
        linkedHashMap.get("name1");
        Set<Entry<String, String>> set2 = linkedHashMap.entrySet();
        Iterator<Entry<String, String>> iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Entry entry = iterator2.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }
}
