package com.keven.shiro.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class ThreadDemo extends Thread{
	
//	CountDownLatch
	
	public  ThreadDemo(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		doService();
	}
	
	public void doService() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName()+": 正在运行! "+i);
		}
	}
	

	
	
	
	public static void main(String[] args) {
		CountDownLatch countDownLatch;
//		BlockingQueue<E> queuw;
	}
    
}
