package com.keven.shiro.multithreading;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Demo {
	
	public static void main(String[] args) {
		Map map =new ConcurrentHashMap<>();  //最多支持16并发，分割成hashtable
		CopyOnWriteArrayList<String> list;   //多写场景下不适用
		CopyOnWriteArraySet<String>  set;
		ConcurrentLinkedDeque<String> queue;
		ArrayBlockingQueue<String> arrayQueue;
		
 		
	}

}
