package net.voovo.list;

import com.alibaba.fastjson.JSONObject;
import net.voovo.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yml
 * @Date: 2020/1/19 10:34
 * 测试对象插入对象
 */
public class ListChangePut {

    public static void main(String[] args) {
        List<User> list=new ArrayList<>();
        User user;
        for (int i = 0; i < 3; i++) {
            user = new User();
            user.setName("Lee"+i);
            list.add(user);
        }
        System.out.println(JSONObject.toJSONString(list));
    }
}
