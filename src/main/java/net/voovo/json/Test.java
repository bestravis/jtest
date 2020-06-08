package net.voovo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

/**
 * @Author yml
 * @Date 2020/5/7
 */
public class Test {
    public static void main(String[] args) {
        String string="{\"key\":1}";
        Object obj=string;

        Object o = JSON.toJSON(obj);
//        Jackson.fromObject
        System.out.println(o);
    }
}
