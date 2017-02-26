package net.flylib.rediskit;

import org.springframework.beans.factory.InitializingBean;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

public class RedisClient implements InitializingBean {
	private Jedis jedis;// 非切片额客户端连接
	private JedisPool jedisPool;// 非切片连接池

	public RedisClient() {
//		Instantiate jedis here is error.
//		jedis = jedisPool.getResource();
	}
	
	@Override 
	public void afterPropertiesSet() throws Exception {
		jedis = jedisPool.getResource();
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	public String set(final String key, String value) {
		jedis.get("");
		return jedis.set(key, value);
	}

	public String get(final String key) {
		return jedis.get(key);
	}
}
