package com.keven.springDemo.designer.proxy;

public class Student implements Person {
	
	private String name;
	public Student(String name) {
		this.name=name;
	}

	@Override
	public void giveMoney() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println(name+"上交班费50元！");

	}

	@Override
	public void save() {
		System.out.println("保存");
		
	}

}
