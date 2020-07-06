package com.keven.springDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.keven.shiro.model.User;

/**
 * 每一个lambda表达式都对应一个类型，通常是接口类型。而“函数式接口”是指仅仅只包含一个抽象方法的接口，
 * 每一个该类型的lambda表达式都会被匹配到这个抽象方法。因为 默认方法 不算抽象方法，所以你也可以给你的函数式接口添加默认方法。
 * @author zdchao
 *
 */
public class LambdaDemo {

	public static void demo1() {
		// 匿名内部类
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());

			}
		}).start();
		// 使用lambda表达式
		new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
	}

	public static void demo2() {
		List<String> names = Arrays.asList("keven", "peter", "derwe");
		List<String> names2 = Arrays.asList("keven", "peter", "derwe");
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});

		Collections.sort(names2, (String o1, String o2) -> o2.compareTo(o1));

		System.out.println(names2);
		
	}
	
	public static void demo3() {
		Consumer<User> greeter = (p) -> System.out.println("Hello, " + p.getName());
		greeter.accept(new User());
		
		
	}
	public static void demo4() {}
	public static void demo5() {}
	

	public static void main(String[] args) {
		demo1();
		demo2();
		demo3();
	}

}
