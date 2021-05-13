package com.keven.springDemo.reflect;

public class Client {
	public static void main(String[] args) {
		BeanUtils util =new BeanUtils();
		try {
			BeanUtils.getClass("com.keven.springDemo.reflect.Person");
			util.getConstructs("com.keven.springDemo.reflect.Person");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
