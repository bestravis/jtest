package oo;

import com.alibaba.fastjson.JSONObject;
import net.voovo.push.SmsSendThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ObjectWithItself {

    private static Logger logger = LoggerFactory.getLogger(ObjectWithItself.class);
    public static void main(String[] args) {

        Object object=new ArrayList<>();
        List list=new ArrayList<>();//方面以后更换list实现，list实例只能用List相关方法
        ArrayList arrayList=new ArrayList<>();//可以使用所有ArrayList的方法
        LinkedList foo=new LinkedList<>();

        logger.info(""+object.getClass());
        logger.info("{}",list.getClass());
        logger.info("{}",arrayList.getClass());
    }
}
