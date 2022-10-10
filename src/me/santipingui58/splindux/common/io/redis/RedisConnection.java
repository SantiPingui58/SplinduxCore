package me.santipingui58.splindux.common.io.redis;

import java.util.List;
import java.util.Set;

import me.santipingui58.splindux.common.io.Connection;
import redis.clients.jedis.JedisPooled;

public final class RedisConnection implements Connection{

	private JedisPooled jedisPooled;
	private String host;
	private int port;
	private String user;
	private String password;
	
	public RedisConnection(String host, int port, String user, String password) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
	}
	
	
	@Override
	public void connect() {
		jedisPooled = new JedisPooled(host, port,user,password);
	}
	
	
	@Override
	public void close() {
		jedisPooled.close();
	}
	
	public String get(String key) {
		   return jedisPooled.get(key);
	}
	
	public void set(String key, String value) {
		   jedisPooled.set(key, value);
	}
	
	
	public List<String> getList(String key) {
		 return  jedisPooled.lrange(key, 0, -1);
	}
	
	
	public void addToList(String key,String s) {
		   jedisPooled.lpush(key, s);
	}
	
	public void removeFromList(String key,String s) {
		   jedisPooled.lpush(key, s);
		   jedisPooled.lrem(key, 0, s);
	}
	
	
	public void setList(String key, List<String> list) {	
		   for (String s : list) 
			   jedisPooled.lpush(key, s);
	}
	
	
	
	public Set<String> getSet(String key) {
		 return  jedisPooled.smembers(key);
	}

	public void addToSet(String key,String value) {
		   jedisPooled.sadd(key, value);
	}
	
	public void removeFromSet(String key,String value) {
		   jedisPooled.srem(key, value);
	}
	
	public void delete(String key) {
			jedisPooled.del(key);
	}




}
