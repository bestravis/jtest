package net.voovo.thread;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import net.voovo.pojo.Article;
import net.voovo.util.Timer;

public class TestInvoke {

	public static void main(String[] args) throws InterruptedException {
		List<String> list=new ArrayList<>();
		List<Article> articleList=new ArrayList<>();
		Timer timer=new Timer();
		for(int i=0;i<10000;i++) {
			list.add(JSONObject.toJSONString(Article.getRadom()));
		}
		TypeReference<Article> typef=new TypeReference<Article>() {};
		for(int i=0;i<10000;i++) {
			articleList.add(JSONObject.parseObject(list.get(i), typef));
		}
		System.out.println(list.get(0));
		timer.stopAndPrint();

//		Thread.sleep(1200);
//		timer.stopAndPrint();
		
	}
}
