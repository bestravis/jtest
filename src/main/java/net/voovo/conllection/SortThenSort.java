package net.voovo.conllection;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: yml
 * @Date: 2019/10/17 15:00
 * 多字段排序
 */
public class SortThenSort {

    static class Treasure{
        Integer id;
        Integer price;
        Integer weight;
        Treasure(){ }
        Treasure(Integer id, Integer price, Integer weight) {
            this.id = id;
            this.price = price;
            this.weight = weight;
        }
        public Integer getId() {
            return id;
        }

        public Integer getPrice() {
            return price;
        }

        public Integer getWeight() {
            return weight;
        }
    }

    public static void main(String[] args) {
        Treasure t1 = new Treasure(1,9,6);
        Treasure t2 = new Treasure(2,12,4);
        Treasure t3 = new Treasure(3,8,5);
        Treasure t4 = new Treasure(4,19,15);
        Treasure t5 = new Treasure(5,22,14);
        Treasure t6 = new Treasure(6,5,16);
        Treasure t7 = new Treasure(7,13,17);
        Treasure t8 = new Treasure(8,22,7);
        int box=40;
        List<Treasure> list=new ArrayList(),tList=new ArrayList();
        tList.add(t1);
        tList.add(t2);
        tList.add(t3);
        tList.add(t4);
        tList.add(t5);
        tList.add(t6);
        tList.add(t7);
        tList.add(t8);

        tList.sort(Comparator.comparing(Treasure::getPrice).reversed());
        tList.sort(Comparator.comparing(Treasure::getWeight).reversed());

        //构造排序器
        Comparator<Treasure> byPrice = Comparator.comparing(Treasure::getPrice).reversed();
        Comparator<Treasure> byWeight = Comparator.comparing(Treasure::getWeight);
        tList.sort(byPrice.thenComparing(byWeight));//排序
        tList.forEach(treasure -> {
            System.out.println(JSONObject.toJSONString(treasure));
        });
//        for(Treasure o:tList){
//
//        }

    }

}
