package me.santipingui58.splindux.bukkit.plugin;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.santipingui58.splindux.bukkit.utils.BukkitConfiguration;
import me.santipingui58.splindux.common.io.config.CoreConfig;
import me.santipingui58.splindux.common.io.mysql.DatabaseConfiguration;
import me.santipingui58.splindux.common.io.redis.RedisConfiguration;


public class BukkitPluginLoader extends JavaPlugin {

	  
	public static BukkitConfiguration CONFIG;
	 BukkitCore core;
	
    @Override
    public void onEnable() {
    	getLogger().info("DETECTED BUKKIT. ENABLING SPLINDUX CORE");
    	CONFIG = new BukkitConfiguration("config.yml",this);
    	
    	DatabaseConfiguration databaseConfiguration = initDatabaseConfiguration();
    	RedisConfiguration redisConfiguration = initRedisConfiguration();
    	CoreConfig coreConfig = new CoreConfig(redisConfiguration, databaseConfiguration, getDataFolder().getPath());
     	Plugin plugin = this;
    	core = new BukkitCore(plugin,coreConfig);
   	 	
 
    }
    
    private DatabaseConfiguration initDatabaseConfiguration() {
    	DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
    	FileConfiguration config = CONFIG.getConfig();
    	databaseConfiguration.setHost(config.getString("database.host"));
    	databaseConfiguration.setPort(config.getInt("database.port"));
    	databaseConfiguration.setDatabase(config.getString("database.database"));
    	databaseConfiguration.setUser(config.getString("database.user"));
    	databaseConfiguration.setPassword(config.getString("database.password"));
    	databaseConfiguration.setMinimumConnections(config.getInt("database.minimumConnections"));
    	databaseConfiguration.setMaximumConnections(config.getInt("database.maximumConnections"));
    	databaseConfiguration.setConnectionTimeout(config.getInt("database.connectionTimeout"));
    	databaseConfiguration.setTestQuery(config.getString("database.testQuery"));
    	return databaseConfiguration;
    }
    
private RedisConfiguration initRedisConfiguration() {
		RedisConfiguration redisConfiguration = new RedisConfiguration();
		FileConfiguration config = CONFIG.getConfig();
		redisConfiguration.setHost(config.getString("redis.host"));
		redisConfiguration.setPort(config.getInt("redis.port"));
		redisConfiguration.setUser(config.getString("redis.config"));
		redisConfiguration.setPassword(config.getString("redis.password"));
		return redisConfiguration;
}

    
}