package net.voovo.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Article {

	private String id;
	
	private String title;
	
	private String openid;
	
	private String content;
	
	private boolean foo;
	
	private List<String> list=new ArrayList<>();
	
	public static Article getRadom() {
		Article tmp=new Article();
		tmp.setId("id"+Math.random());
		tmp.setTitle("title"+Math.random());
		tmp.setOpenid("openid"+Math.random());
		tmp.setContent("content"+Math.random());
		tmp.list=Arrays.asList("r"+Math.random(),"1","2");
		return tmp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isFoo() {
		return foo;
	}

	public void setFoo(boolean foo) {
		this.foo = foo;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	
}
