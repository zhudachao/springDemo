package com.keven.shiro.multithreading;

public class RunnableDemo implements Runnable {

	public RunnableDemo(String name) {
		super();
	}

	@Override
	public void run() {
		doService();

	}

	public void doService() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ": 正在运行! " + i);
		}
	}

	public static void main(String[] args) {
		RunnableDemo demo1 = new RunnableDemo("t1");
		RunnableDemo demo2 = new RunnableDemo("t2");
		Thread t1 = new Thread(demo1);
		Thread t2 = new Thread(demo2);
		t1.start();
		t2.start();
	}

}
