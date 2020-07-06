package com.keven.springDemo.designer.proxy;

public class StudentProxy implements Person {
	
	Student stu;
	
	public StudentProxy(Person stu) {
		if(stu.getClass()==Student.class) {
			this.stu=(Student) stu;
		}
	}
	

	@Override
	public void giveMoney() {
	
	   stu.giveMoney();

	}


	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

}
