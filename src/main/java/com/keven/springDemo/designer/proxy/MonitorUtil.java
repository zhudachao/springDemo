package com.keven.springDemo.designer.proxy;

public class MonitorUtil {
	private static ThreadLocal<Long> t1 =new ThreadLocal<Long>();
	
	public static void start() {
		t1.set(System.currentTimeMillis());
	}
	
	public static void finish(String methodName) {
		Long finishTime =System.currentTimeMillis();
		System.out.println(methodName+"方法耗时"+ (finishTime-t1.get())+"ms");
	}

}
