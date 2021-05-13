package com.keven.shiro.dynmic_proxy;

public class Client {
	public static void main(String[] args) {
		Target target =new TargetImpl();
		DynamicProxyHandler handler =new DynamicProxyHandler();
		Target proxys = (Target) handler.getProxyInstance(target);
		proxys.action();
		
	}

}
