package com.keven.springDemo.annotation;

import java.lang.reflect.InvocationTargetException;

public class Test {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Person p =new  Person();

		Validate.valid(p);;
	}

}
