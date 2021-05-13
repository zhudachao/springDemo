package com.keven.shiro.dynmic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyHandler implements InvocationHandler{

	private Object obj;
	
	public Object getProxyInstance(Object obj) {
		this.obj =obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), this);
	}	
	
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("准备代理");
		Object returnVal = method.invoke(this.obj, args);
		System.out.println("代理后");
		return returnVal;
	}

}
