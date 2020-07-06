package com.keven.springDemo.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class LamdaDemo {
	//Lambda 表达式将函数当成参数传递给某个方法，或者把代码本身当作数据处理
	public static void lamdaTest() {
		
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		//传统匿名对象排序
//		Collections.sort(names,new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {				
//				return o1.compareTo(o2);
//			}
//		});
		//lamda表达式三种实例
		names.sort((e1,e2)-> e1.compareTo(e2));
		Collections.sort(names,(e1,e2)-> e1.compareTo(e2));		
		System.out.println(names);
		
		names.forEach( e-> {String toNames=e+" ";System.out.println(toNames);});
	}
	
	
	public static void main(String[] args) {
		lamdaTest();
	}

}
