package net.voovo.conllection;

import java.util.ArrayList;
import java.util.List;

import net.voovo.pojo.User;


public class UserListToArray {

	public static void main(String[] args) {
		User user=new User();
		user.setName("aa");
		List<User> list=new ArrayList<User>();
		list.add(user);
		user=new User();
		user.setName("bb");
		list.add(user);
		//取出List<Object>中的某个属性，保存为数组
		String[] arr=list.stream().map(User::getName).toArray(String[]::new);
		
		System.out.println(arr);
	}
}
