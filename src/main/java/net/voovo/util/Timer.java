package net.voovo.util;

public class Timer {

	public long createTime;
	
	public long endTime;
	
	public Timer() {
		this.start();
	}
	
	public Timer(long time) {
		this.createTime=time;
	}
	
	public void stop() {
		this.endTime=System.currentTimeMillis();
	}
	
	public void start() {
		this.createTime=System.currentTimeMillis();
	}
	
	public void stopAndPrint(){
		this.stop();
		System.out.println("usedTime:"+(endTime-createTime)+"ms");
	}
}
