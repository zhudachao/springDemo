package com.keven.springDemo.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.keven.springDemo.service.PublishService;

@Service("publishService")
public class PublishServiceImpl implements PublishService {
	private static Logger logger = LoggerFactory.getLogger(PublishServiceImpl.class);

	private StringRedisTemplate redisTempplate;

	@Override
	public String sendMessage(String name) {

		try {
			redisTempplate.convertAndSend("TOPOC_USERNAME", name);
			return "消息发送成功";
		} catch (Exception e) {
			logger.error("消息发送失败：{}", e.getMessage());
			return "消息嘎松失败";
		}
	}

}
