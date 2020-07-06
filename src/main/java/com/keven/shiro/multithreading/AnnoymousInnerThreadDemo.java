package com.keven.shiro.multithreading;

public class AnnoymousInnerThreadDemo {
	
	public static void main(String[] args) {
		
		Runnable r =new Runnable() {
			@Override
			public void run() {
				doService();
				
			}
		};
		
		new Thread(r).start();
	}
	
	
	public static void doService() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+": 正在运行! "+i);
		}
	}
	
	
}
