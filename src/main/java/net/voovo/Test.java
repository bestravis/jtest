package net.voovo;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import net.voovo.pojo.User;
import net.voovo.util.Timer;

public class Test {

<<<<<<< HEAD
	public static void main(String[] args) throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
=======
	public static void main(String[] args) {
		f();
	}

	public static void f() {
		String[] a = new String[2];
		Object[] b = a;

		Integer[] i=new Integer[2];
		Object[] c = i;
>>>>>>> 8e6892e520566ca9f19c6e4507606d0fa12e6518

		a[0] = "hi";
		System.out.println(JSONObject.toJSONString(a));
		System.out.println(c.getClass());
		b[1] = Integer.valueOf(42);
	}
}
