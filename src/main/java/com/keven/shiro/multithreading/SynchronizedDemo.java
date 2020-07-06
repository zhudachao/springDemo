package com.keven.shiro.multithreading;


public class SynchronizedDemo implements Runnable{
	
	public static void main(String[] args) {
		SynchronizedDemo demo1 =new SynchronizedDemo();
		SynchronizedDemo demo2 =new SynchronizedDemo();
		new Thread(demo1).start();
		new Thread(demo2).start();
	}
	
	Object object =new Object();
	public int a =100;
	
	@Override
	public void run() {
		doService();
		
	}
	
	//同步对象
//	public void doService() {
//		synchronized (object) {
//			while(a>0) {
//				System.out.println("线程："+java.lang.Thread.currentThread().getName()+"执行到："+ a);
//				a--;
//			}
//			
//		}
//	}
	//同步方法
	public synchronized void doService() {
			
		while(a>0) {
			
				System.out.println("线程："+java.lang.Thread.currentThread().getName()+"执行到："+ a);
				a--;
			}
			
		}


}
