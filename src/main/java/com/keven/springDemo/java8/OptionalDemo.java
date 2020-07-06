package com.keven.springDemo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
	
	
	public static void demo() {
		
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia","aqila",null);
		
		Optional<List<String>> name = Optional.of(names);
		
		
		System.out.println(name);
		
	}
	
	public static void main(String[] args) {
		demo();
	}

}
