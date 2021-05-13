package com.keven.shiro.dynmic_proxy;

public class TargetImpl implements Target{

	@Override
	public void action() {		
		System.out.println("实现目标方法");
	}

}
