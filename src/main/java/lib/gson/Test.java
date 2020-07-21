package lib.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @Author yml
 * @Date 2020/4/17
 */
public class Test {
    public static void main(String[] args) {
        Gson gson=new Gson();

        String s = getGsonAndSkipField("age","memo","birthday").toJson(getDogInstance(), Dog.class);
        System.out.println(s);
    }

    public static Dog getDogInstance(){
        Dog build = Dog.builder().age((byte) 1).birthday(new Date()).memo("memo").name("tom").type("hasiki").build();
        return build;
    }

    public static Gson getGsonAndSkipField(String... fields){
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            //排除字段
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                for(String k:fields){
                    if(f.getName().contains(k)){
                        return true;
                    }
                }
                return false;
            }
            //排除类
            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        }).create();
        return gson;
    }
}
