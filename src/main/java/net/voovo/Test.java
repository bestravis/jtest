package net.voovo;


import cn.hutool.core.convert.Convert;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> integers = Convert.toList(Integer.class, "1,2,3".split(","));
		System.out.println(integers);

	}


}
