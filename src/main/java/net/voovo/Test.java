package net.voovo;


import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

	private static String dateStr;

	static {
		Calendar instance = Calendar.getInstance();
		dateStr = (instance.get(Calendar.MONTH) + 1) + "" + instance.get(Calendar.DAY_OF_MONTH);
	}



	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(dateStr);

		Model model = new Model();
		model.id = 1001;
		model.name = "gaotie";

		// {"id":1001,"name":"gaotie"}
		String text_normal = JSON.toJSONString(model);
		System.out.println(text_normal);

		// [1001,"gaotie"]
		String text_beanToArray = JSON.toJSONString(model, SerializerFeature.BeanToArray);
		System.out.println(text_beanToArray);

		// support beanToArray & normal mode
		JSON.parseObject(text_beanToArray, Feature.SupportArrayToBean);
	}


	public void getDate(){
		Calendar instance = Calendar.getInstance();
		String date = (instance.get(Calendar.MONTH) + 1) + "" + instance.get(Calendar.DAY_OF_MONTH);

	}


}

@Data
@NoArgsConstructor
class Model {
	public int id;
	public String name;
}