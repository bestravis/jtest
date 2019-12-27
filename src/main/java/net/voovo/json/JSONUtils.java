package net.voovo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author: yml
 * @Date: 2019/12/27 14:12
 */
public class JSONUtils {

    //JSONString to JavaObject
    public static <T> T toJavaObject(String jsonString, Class<T> clazz){
        return JSON.parseObject(jsonString,clazz);
    }

    //JSONObject to JavaObject
    public static <T> T toJavaObject(JSONObject json, Class<T> clazz){
        return JSON.toJavaObject(json, clazz);
    }
}
