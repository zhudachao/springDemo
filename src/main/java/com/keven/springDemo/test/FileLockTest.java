package com.keven.springDemo.test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Collection;
import java.util.Collections;


public class FileLockTest {
	
	public static void main(String[] args) throws IOException {
			
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					getLock();
					Thread.sleep(3000);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		},"t1").start();
//			new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				try {
//					getLock();
//					Thread.sleep(3000);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//		},"t2").start();
//		
		
	}
	
	public static void getLock() throws IOException {
		File file =new File("E:\\temp\\logfile.txt");
		RandomAccessFile raf =new RandomAccessFile(file, "rw");
		FileChannel fc =raf.getChannel();
		FileLock lock =fc.tryLock();
		if(lock==null) {
			System.out.println("获取锁失败");
		}else {
			System.out.println("获取锁");
		}
		
//	    lock.release();
	}
	
	

}
