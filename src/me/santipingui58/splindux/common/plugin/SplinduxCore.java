package me.santipingui58.splindux.common.plugin;

import me.santipingui58.splindux.common.command.CommandManager;
import me.santipingui58.splindux.common.cosmetics.CosmeticManager;
import me.santipingui58.splindux.common.io.config.CoreConfig;
import me.santipingui58.splindux.common.io.mysql.DatabaseConfiguration;
import me.santipingui58.splindux.common.io.mysql.DatabaseConnection;
import me.santipingui58.splindux.common.io.redis.RedisConfiguration;
import me.santipingui58.splindux.common.io.redis.RedisConnection;
import me.santipingui58.splindux.common.logger.Loggeable;
import me.santipingui58.splindux.common.logger.SplinduxLogger;

public abstract class SplinduxCore implements ICore,Loggeable {


	private CommandManager commandManager;
	private CosmeticManager cosmeticManager;
	private SplinduxLogger splinduxLogger;
	private RedisConnection redisConnection;
	private DatabaseConnection databaseConnection;
	private CoreConfig coreConfig;
	
	
	public SplinduxCore(CoreConfig coreConfig) {
		this.coreConfig = coreConfig;
	}
	
	public void load() {
		this.splinduxLogger = new SplinduxLogger(coreConfig.getPluginPath());
		io();
		loadManagers();
		
		
	}
	
	private void io() {
		RedisConfiguration redisConfiguration = coreConfig.getRedisConfiguration();
		DatabaseConfiguration databaseConfiguration = coreConfig.getDatabaseConfiguration();
		
		this.redisConnection = new RedisConnection(redisConfiguration.getHost(),redisConfiguration.getPort(),redisConfiguration.getUser(),redisConfiguration.getPassword());	
		this.databaseConnection = new DatabaseConnection(databaseConfiguration.getHost(), databaseConfiguration.getPort(), databaseConfiguration.getDatabase(), databaseConfiguration.getUser(), databaseConfiguration.getPassword(), 
				databaseConfiguration.getMinimumConnections(), databaseConfiguration.getMaximumConnections(), databaseConfiguration.getConnectionTimeout(), databaseConfiguration.getTestQuery());
				
	}
	

	
	
	private void loadManagers() {
		this.commandManager = new CommandManager();
		this.cosmeticManager = new CosmeticManager();
	}
	
	
	
	
	public CommandManager getCommandManager() {
		return this.commandManager;
	}
	
	public CosmeticManager getCosmeticManager() {
		 return this.cosmeticManager;
	}
	
	
	public SplinduxLogger getSplinduxLogger() {
	return this.splinduxLogger;
}

	public RedisConnection getRedisConnection() {
	return this.redisConnection;
}
	

	public DatabaseConnection getDatabaseConnection() {
	return this.databaseConnection;
}
	
	
}
