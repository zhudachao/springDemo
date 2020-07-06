package com.keven.springDemo.designer.proxy;

public class StaticProxyTest {
	
	public static void main(String[] args) {
		Person zhangsan =new Student("zhangsan");
		
		StudentProxy proxy =new StudentProxy(zhangsan);
		
		proxy.giveMoney();
		
	}

}
