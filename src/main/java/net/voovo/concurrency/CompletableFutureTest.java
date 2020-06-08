package net.voovo.concurrency;
import cn.hutool.http.HttpUtil;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

/**
 * 测试并发执行
 */
public class CompletableFutureTest {
//	private Logger logger = LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) throws InterruptedException {
		List list = doSomeWork(new String[]{"1", "2"});
		System.out.println(list);
	}

	public static List doSomeWork(String... names){
		List<CompletableFuture> list=new ArrayList<>();
		List answer=new ArrayList();
		for(String name:names){
			CompletableFuture<String> future= CompletableFuture.supplyAsync(()->{
				System.out.println("work:"+name);
				return name;
			});
			future.whenComplete(new BiConsumer<String, Throwable>() {
				@Override
				public void accept(String s, Throwable throwable) {
					answer.add(s);
				}
			});
			list.add(future);
		}

		CompletableFuture[] completableFutures = list.toArray(new CompletableFuture[list.size()]);
		CompletableFuture.allOf(completableFutures).join();
		System.out.println("done");
		return answer;
	}

	public void simpleTest(){
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