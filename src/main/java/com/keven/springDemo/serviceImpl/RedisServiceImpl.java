package com.keven.springDemo.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.keven.springDemo.config.RedisClientbak;
import com.keven.springDemo.config.RedisConfigbak;
import com.keven.springDemo.redis.RedisConfig;
import com.keven.springDemo.redis.RedisUtil;
import com.keven.springDemo.service.RedisService;

//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.ShardedJedis;

/**
 * 使用三种方式对redis处理 1.
 * @author zdchao
 *
 */


@Service("redisService")
@Component
public class RedisServiceImpl implements RedisService {
	private static Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

//	@Autowired
//	private RedisClient redisClient;
//	@Autowired
//	private RedisTemplate<String, String> redisTemplate;	
//	private ShardedJedis sJedis = null;
//	private Jedis jedis = null;
	
	
	

	@Autowired
	private RedisUtil redisUtil;
	


	@Override
	public String get(String key) {
//		RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//		String val = redisConfig.getJedis().get(key);
//		String strVal =String.valueOf(val);
//		System.out.println(val);
//		String val =(String) redisTemplate.opsForValue().get(key);
		String val= (String) redisUtil.get(key);
		
		return val;
	}

	@Override
	public boolean set(String key, String value) {
//		RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//		jedis = redisClient.getJedis();		
//		String str = jedis.set(serializer.serialize(key), serializer.serialize(value));  	
		//不使用sharedjedis插入
//		jedis = redisConfig.getJedis();	
//		String str =jedis.set(key,value);
//		String str =jedis.set(serializer.serialize(key), serializer.serialize(value));
		
//		ValueOperations<String,String> operations= redisTemplate.opsForValue(); 
//		operations.set(key,value);
		
		boolean val =redisUtil.set(key, value);
			
		logger.info("是否插入成功:{},key:{},value:{}",val,key,redisUtil.get(key));		
		return val;
	}

	@Override
	public Long expire(String key, int expire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long remove(String key) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Long expire(String key, int expire) {
//		sJedis = redisClient.getJedis();
//		Long result =null;
//		if(sJedis.exists(key)) {
//			result= jedis.expire(key, expire);			
//		}else {
//			logger.error("key值：{}不存在",key);
//		}
//		redisClient.release(sJedis);
//		return result;
//	}
//
//	@Override
//	public Long remove(String key) {
//		sJedis = redisClient.getJedis();
//		Long result =null;
//		if(sJedis.exists(key)) {
//			result= jedis.del(key);			
//		}else {
//			logger.error("key值：{}不存在",key);
//		}
//		redisClient.release(sJedis);
//		return result;
//
//	}

	// @Resource
	// private RedisTemplate<String, ?> redisTemplate;

	// public boolean set(final String key, final String value) {
	// boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
	// @Override
	// public Boolean doInRedis(RedisConnection connection) throws
	// DataAccessException {
	// RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
	// connection.set(serializer.serialize(key), serializer.serialize(value));
	// return true;
	// }
	// });
	// return result;
	// }
	//
	// public String get(final String key) {
	// String result = redisTemplate.execute(new RedisCallback<String>() {
	// @Override
	// public String doInRedis(RedisConnection connection) throws
	// DataAccessException {
	// RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
	// byte[] value = connection.get(serializer.serialize(key));
	// return serializer.deserialize(value);
	// }
	// });
	// return result;
	// }
	//
	// public boolean expire(final String key, long expire) {
	// return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
	// }
	//
	// public boolean remove(final String key) {
	// boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
	// @Override
	// public Boolean doInRedis(RedisConnection connection) throws
	// DataAccessException {
	// RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
	// connection.del(key.getBytes());
	// return true;
	// }
	// });
	// return result;
	// }

}
