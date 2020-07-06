package com.keven.springDemo.designer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler<T> implements InvocationHandler{

	T target;
	public MyInvocationHandler(T target) {
	       this.target = target;
	    }
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("代理执行"+method.getName());
		Object result =null;
		MonitorUtil.start();
				
	   result =method.invoke(target, args);
		MonitorUtil.finish(method.getName());
		
		
		return result;
	}

}
