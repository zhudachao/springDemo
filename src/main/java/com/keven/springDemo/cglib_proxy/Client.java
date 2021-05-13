package com.keven.springDemo.cglib_proxy;

import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class Client {
	
	public static void main(String[] args) {
//		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\");
		Enhancer enchancer =new Enhancer();
		enchancer.setSuperclass(Target.class);
		enchancer.setCallback(new ProxyInterceptor());
		Target target = (Target) enchancer.create();
		target.execute();
		
		
	}

}
