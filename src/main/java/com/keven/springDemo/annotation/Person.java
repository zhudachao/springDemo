package com.keven.springDemo.annotation;

public class Person {
	
	@NotNull(value= "姓名")		
	public  String name;
	
	public void call(String phone) {
		System.out.println("拨打电话："+ phone);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
