package com.keven.springDemo.designer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class dynamicProxyTest {

	public static void main(String[] args) {
		Person zhangsan = new Student("zhangsan");

		InvocationHandler myinvocaHandler = new MyInvocationHandler<Person>(zhangsan);

		Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),
				new Class<?>[] { Person.class }, myinvocaHandler);

		stuProxy.giveMoney();
		stuProxy.save();
	}

}
