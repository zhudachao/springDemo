package com.keven.shiro.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo implements Runnable{
	
	public static int a =100;
	
	ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		lock.lock();
		doService();
		lock.unlock();
		
	}
	
	public  void doService() {
		while(a>0) {
				System.out.println("线程："+java.lang.Thread.currentThread().getName()+"执行到："+ a);
				a--;
			}
			
		}
	

}
