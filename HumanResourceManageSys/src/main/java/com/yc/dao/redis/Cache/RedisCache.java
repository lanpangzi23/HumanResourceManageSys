package com.yc.dao.redis.Cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

public class RedisCache implements Cache {
	/*
	 * 日志对象
	 */
	private static Logger logger = LogManager.getLogger(RedisCache.class);
	private String id;
	private Jedis redisClient = createRedis();
	// 用于同步锁
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public RedisCache(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Cache instance requires an Id");
		}
		logger.debug("create an cache instance with id:" + id);
		this.id = id;
	}

	// 获取当前缓存的Id号
	public String getId() {
		return this.id;
	}

	// 将缓存数据清空，实际上清空redis的数据
	public void clear() {
		logger.info("redis begin to clear...");
		this.redisClient.flushDB();
	}

	// 通过key到缓存redis中取值
	public Object getObject(Object key) {
		// 缓存穿透
		byte[] values = this.redisClient.get(SerializableUtil.serialize(key));
		if (values == null) {
			return null;
		}
		Object obj = SerializableUtil.unSerialize(values);
		logger.info("redis get an object with key" + key + ":vaule is:" + obj);
		return obj;
	}

	// 获取值
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	// 获取数据量
	public int getSize() {
		Long size = this.redisClient.dbSize();
		int s = Integer.valueOf(size + "");
		return s;
	}

	// 存
	public void putObject(Object key, Object value) {
		byte[] keybyte = SerializableUtil.serialize(key);
		byte[] valuebyte = SerializableUtil.serialize(value);
		this.redisClient.expire(keybyte, 0);
	}

	// 移除
	public Object removeObject(Object key) {
		byte[] keybyte = SerializableUtil.serialize(key);
		return this.redisClient.expire(keybyte, 0);
	}

	/*
	 * jedis从连接池中取
	 */
	public static Jedis createRedis() {
		Jedis jedis = RedisPool.getPool().getResource();
		return jedis;
	}
}
