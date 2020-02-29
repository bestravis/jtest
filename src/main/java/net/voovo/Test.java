package net.voovo;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import net.voovo.pojo.User;
import net.voovo.util.Timer;

public class Test {

	public static void main(String[] args) {
		f();
	}

	public static void f() {
		String[] a = new String[2];
		Object[] b = a;

		Integer[] i=new Integer[2];
		Object[] c = i;

		a[0] = "hi";
		System.out.println(JSONObject.toJSONString(a));
		System.out.println(c.getClass());
		b[1] = Integer.valueOf(42);
	}
}
