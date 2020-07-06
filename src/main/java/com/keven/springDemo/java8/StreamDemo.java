package com.keven.springDemo.java8;

import java.util.Arrays;
import java.util.List;

/**
 * stream表示能应用在一组元素上执行上一次执行的操作序列,将操作串联起来
 * stream串行和parallelStream并行
 * @author zdchao
 *
 */
public class StreamDemo {
	
	public static void demo() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia","aqila");
//		names.stream().filter(e->e.endsWith("a")).forEach(e->System.out.println(e));
		names.stream().filter(e->e.endsWith("a")).sorted().forEach(e->System.out.println(e));
		
		names.parallelStream().filter(null).reduce(null).ifPresent(null);
		names.parallelStream().reduce(null).isPresent();
	}
	
	
	
	
	
	public static void main(String[] args) {
		demo();
	}

}
