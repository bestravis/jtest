package net.voovo.concurrency;
import cn.hutool.http.HttpUtil;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 测试并发执行
 */
public class CompletableFutureTest {
//	private Logger logger = LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) throws InterruptedException {

		List<CompletableFuture> list=new ArrayList<>();

		StopWatch watch = new StopWatch();
		watch.start();
		System.out.println("start:"+watch.getTime());
		for (int i = 0; i < 15; i++) {
			CompletableFuture<String> future= CompletableFuture.supplyAsync(()->{
				String result = HttpUtil.get("http://localhost:8070/test?id=1");
				System.out.println(result);
				return result;
			});
			list.add(future);
		}

		CompletableFuture[] completableFutures = list.toArray(new CompletableFuture[list.size()]);
		CompletableFuture.allOf(completableFutures).whenComplete((r,e)->{
			System.out.println("done:"+watch.getTime());
		}).join();
	}
}