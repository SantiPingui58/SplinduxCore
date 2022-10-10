package me.santipingui58.splindux.common.io.config;

import me.santipingui58.splindux.common.io.mysql.DatabaseConfiguration;
import me.santipingui58.splindux.common.io.redis.RedisConfiguration;

public class CoreConfig {

	private RedisConfiguration redisConfiguration;
	private DatabaseConfiguration databaseConfiguration;
	private String pluginPath;
	
	public CoreConfig(RedisConfiguration redisConfiguration,DatabaseConfiguration databaseConfiguration,String pluginPath) {
		this.redisConfiguration = redisConfiguration;
		this.databaseConfiguration = databaseConfiguration;
		this.pluginPath = pluginPath;
	}

	public String getPluginPath() {
		return this.pluginPath;
	}
	
	public RedisConfiguration getRedisConfiguration() {
		return redisConfiguration;
	}

	public DatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}


	
	
	
	
}
