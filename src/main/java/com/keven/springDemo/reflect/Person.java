package com.keven.springDemo.reflect;

public class Person {
	
	private String id;
	private String name;
	
	public void  dance(String name) {
		System.out.println(getName()+ "跳舞");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person(String name) {
		super();
		this.name = name;
	}
	
	
	

}
