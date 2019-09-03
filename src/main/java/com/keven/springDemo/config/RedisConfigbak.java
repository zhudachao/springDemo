package com.keven.springDemo.config;


import org.springframework.stereotype.Component;



@Component
public class RedisConfigbak {
	
//	private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);
//	private static 	JedisPool pool;
//
//	private final static PropertiesConfiguration  prop= PropertiesUtils.INSTANCE.getConfig();
//	private static int index = 1;
//		/**
//	 * 根据需要可添加配置参数，配置多个redis地址
//	 * 
//	 * @return
//	 */
//	@Bean
//	public JedisPool redisPoolFactory() {	
//		
//		logger.info("JedisPool注入成功！！");
//		logger.info("redis地址：" +prop.getString("redis.host")  + ":" + prop.getString("redis.port"));
//		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//		jedisPoolConfig.setMaxIdle(Integer.parseInt(prop.getString("redis.pool.max-idle")));
//		jedisPoolConfig.setMaxWaitMillis(Long.parseLong(prop.getString("redis.timeout")));
//		
//		
////		List<JedisShardInfo> jdsInfoList = new ArrayList<JedisShardInfo>();
////		JedisShardInfo infoA = new JedisShardInfo(prop.getString("redis.host"),  prop.getString("redis.port"));
////		infoA.setPassword(prop.getString("redis.password"));
////		jdsInfoList.add(infoA);
//		
////		pool = new JedisPool(poolConfig, host, port, timeout, password)
//
//		pool = new JedisPool(jedisPoolConfig,prop.getString("redis.host"), prop.getInt("redis.port"),
//				prop.getInt("redis.timeout"),
//				prop.getString("redis.password"));
//		
//		
//		return pool;
//	}
//
//	public  synchronized Jedis getJedis() {
//
//		Jedis jds = null;
//			String key = generateKey();
//			try {
//				jds = redisPoolFactory().getResource();
//				
//				logger.info("hostInfo:{}",jds.getClient().getHost());
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
////				pool.returnResource(jds);
//				release(jds);
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
//    public static void release(Jedis jedis) {
//        
//        if (jedis != null) {
//        	jedis.close();;  // 已废弃，推荐使用jedis.close()方法
//        }
//    }
//	

}