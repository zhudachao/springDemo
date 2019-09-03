package com.keven.springDemo.config;

import org.springframework.stereotype.Component;

@Component
public class RedisClientbak {
	
//	private static Logger logger = LoggerFactory.getLogger(RedisClient.class);
//	private static ShardedJedisPool pool;
//
//	private final static PropertiesConfiguration  prop= PropertiesUtils.INSTANCE.getConfig();
//	private static int index = 1;
//		/**
//	 * 根据需要可添加配置参数，配置多个redis地址
//	 * 
//	 * @return
//	 */
//	@Bean
//	public ShardedJedisPool redisPoolFactory() {	
//		
//		logger.info("JedisPool注入成功！！");
//		logger.info("redis地址：" +prop.getString("redis.host")  + ":" + prop.getString("redis.port"));
//		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//		jedisPoolConfig.setMaxIdle(Integer.parseInt(prop.getString("redis.pool.max-idle")));
//		jedisPoolConfig.setMaxWaitMillis(Long.parseLong(prop.getString("redis.timeout")));
//		
//		List<JedisShardInfo> jdsInfoList = new ArrayList<JedisShardInfo>();
//		JedisShardInfo infoA = new JedisShardInfo(prop.getString("redis.host"),  prop.getString("redis.port"));
//		infoA.setPassword(prop.getString("redis.password"));
//		jdsInfoList.add(infoA);
//
//		pool = new ShardedJedisPool(jedisPoolConfig, jdsInfoList);
//		return pool;
//	}
//
//	public  synchronized ShardedJedis getJedis() {
//
//		ShardedJedis jds = null;
////		for (int i = 0; i < 100; i++) {
//			String key = generateKey();
//			try {
//				jds = redisPoolFactory().getResource();
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
////				pool.returnResource(jds);
//			}
////		}
//		return jds;
//	}
//
//	public static String generateKey() {
//		return String.valueOf(Thread.currentThread().getId()) + "_" + (index++);
//	}
//	
//	/**
//     * 将Jedis对象（连接）归还连接池
//     * @param jedisPool 连接池
//     * @param jedis 连接对象
//     */
//    public static void release(ShardedJedis jedis) {
//        
//        if (jedis != null) {
//        	jedis.close();;  // 已废弃，推荐使用jedis.close()方法
//        }
//    }
//	
//	@Test
//	public  void test() {
//		ShardedJedis jds = new RedisClient().getJedis();
//		jds.set("user001", "abc");
//		System.out.println(jds.get("user001"));
//		
//	}
//	
//	@Bean
//	public static ConfigureRedisAction configureRedisAction() {
//	    return ConfigureRedisAction.NO_OP;
//	}

}