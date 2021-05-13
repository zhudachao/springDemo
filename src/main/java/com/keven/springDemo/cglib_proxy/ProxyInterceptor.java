package com.keven.springDemo.cglib_proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ProxyInterceptor implements MethodInterceptor{

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy methodProxy) throws Throwable {
		System.out.println("before execute...");
		Object result = methodProxy.invokeSuper(arg0, arg2);
		System.out.println("after execute...");
		return result;
	}
	


}
