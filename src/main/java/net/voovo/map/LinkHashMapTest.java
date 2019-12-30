package net.voovo.map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LinkHashMapTest {

    public static void main(String[] args) {
        JSONObject test= JSONArray.parseObject("{\"in my world\": [{\"char\": \"in\", \"score\": 70}, {\"char\": \"my\", \"score\": 60}, {\"char\": \"world\", \"score\": 60}], \"on my world\": [{\"char\": \"on\", \"score\": 60}, {\"char\": \"my\", \"score\": 80}, {\"char\": \"world\", \"score\": 50}]}");

        TreeMap<String,Object> treeMap=JSONObject.parseObject(test.toJSONString(), new TypeReference<TreeMap<String,Object>>(){});





        System.out.println(JSONObject.toJSONString(treeMap));



    }
}
