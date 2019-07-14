package com.zhu.testdemo1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class Redis {
	
	@Autowired
	private Redisconfig redisConfig;
	
	//	配置jedisconfig类，来配置jedisPool
	@Bean
	public JedisPool jedisPoolFactory() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
		jedisPoolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
		jedisPoolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait()*1000);
		JedisPool pool = new JedisPool(jedisPoolConfig,redisConfig.getHost(),redisConfig.getPort(),
				redisConfig.getTimeout()*1000,null,0);
		return pool;
	}
	
	
}
