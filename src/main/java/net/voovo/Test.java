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
		List list=Arrays.asList(1,2,3,8,10);

		for (Object o : list) {
			System.out.println(o);
		}

		JSONArray array = JSONObject.parseArray("[{\"versionId\":1191,\"bookId\":1197,\"cover\":\"http://lzjy.oss-cn-shenzhen.aliyuncs.com/LZJY/english/book/misterwolf/misterwolfA01.png\",\"language\":2,\"versionName\":\"Mister Wolf's Plan\",\"preface\":\"\",\"summary\":\"\",\"purchaseLink\":null,\"author\":\"[英] 莫妮卡·休斯 等 / 著 【英】托尼·罗斯 等 / 绘 高静云/译\",\"press\":\"\",\"typeId\":\"346\",\"typeName\":\"培生Pearson幼儿英语基础级（42册）\",\"status\":4,\"isNesting\":null,\"isbn\":\"9787535374868\",\"pageList\":null,\"recordListDto\":null,\"packetList\":null},{\"versionId\":1189,\"bookId\":1195,\"cover\":\"http://lzjy.oss-cn-shenzhen.aliyuncs.com/LZJY/english/book/toomanypet/toomanypetA01.png\",\"language\":2,\"versionName\":\"Too Many Pets\",\"preface\":\"\",\"summary\":\"\",\"purchaseLink\":null,\"author\":\"[英] 莫妮卡·休斯 等 / 著 【英】托尼·罗斯 等 / 绘 高静云/译\",\"press\":\"\",\"typeId\":\"346\",\"typeName\":\"培生Pearson幼儿英语基础级（42册）\",\"status\":4,\"isNesting\":null,\"isbn\":\"9787535374868\",\"pageList\":null,\"recordListDto\":null,\"packetList\":null},{\"versionId\":1198,\"bookId\":1204,\"cover\":\"http://lzjy.oss-cn-shenzhen.aliyuncs.com/LZJY/english/book/thejumping/thejumpingA01.png\",\"language\":2,\"versionName\":\"The Jumping Jester\",\"preface\":\"\",\"summary\":\"\",\"purchaseLink\":null,\"author\":\"[英] 莫妮卡·休斯 等 / 著 【英】托尼·罗斯 等 / 绘 高静云/译\",\"press\":\"\",\"typeId\":\"346\",\"typeName\":\"培生Pearson幼儿英语基础级（42册）\",\"status\":4,\"isNesting\":null,\"isbn\":\"9787535374868\",\"pageList\":null,\"recordListDto\":null,\"packetList\":null},{\"versionId\":1188,\"bookId\":1194,\"cover\":\"http://lzjy.oss-cn-shenzhen.aliyuncs.com/LZJY/english/book/whowillmar/whowillmarA01.png\",\"language\":2,\"versionName\":\"Who Will Marry Maisie\",\"preface\":\"\",\"summary\":\"\",\"purchaseLink\":null,\"author\":\"[英] 莫妮卡·休斯 等 / 著 【英】托尼·罗斯 等 / 绘 高静云/译\",\"press\":\"\",\"typeId\":\"346\",\"typeName\":\"培生Pearson幼儿英语基础级（42册）\",\"status\":4,\"isNesting\":null,\"isbn\":\"9787535374868\",\"pageList\":null,\"recordListDto\":null,\"packetList\":null},{\"versionId\":1192,\"bookId\":1198,\"cover\":\"http://lzjy.oss-cn-shenzhen.aliyuncs.com/LZJY/english/book/snaphappy0/snaphappy0A01.png\",\"language\":2,\"versionName\":\"Snap Happy\",\"preface\":\"\",\"summary\":\"\",\"purchaseLink\":null,\"author\":\"[英] 莫妮卡·休斯 等 / 著 【英】托尼·罗斯 等 / 绘 高静云/译\",\"press\":\"\",\"typeId\":\"346\",\"typeName\":\"培生Pearson幼儿英语基础级（42册）\",\"status\":4,\"isNesting\":null,\"isbn\":\"9787535374868\",\"pageList\":null,\"recordListDto\":null,\"packetList\":null}]");

	}
}
