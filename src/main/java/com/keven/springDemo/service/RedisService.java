package com.keven.springDemo.service;

public interface RedisService {
	String get(String key);
	boolean set(String key, String value);
	Long expire(String key,int expire);
	Long remove(String key);
	

}
