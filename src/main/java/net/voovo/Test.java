package net.voovo;

<<<<<<< HEAD
public class Test {

	public static void main(String[] args) {
=======

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.BiConsumer;

public class Test {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
>>>>>>> 1e85abab7379e85bdca4faca96e3a38ba940a5f2

		int number=0;
		do{
			number=number+1;
			System.out.println("今天是星期 "+number);
		}while (number!=7);

<<<<<<< HEAD
	}

}
=======
}
>>>>>>> 1e85abab7379e85bdca4faca96e3a38ba940a5f2
