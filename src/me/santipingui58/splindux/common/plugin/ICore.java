package me.santipingui58.splindux.common.plugin;

import me.santipingui58.splindux.common.cosmetics.CosmeticManager;
import me.santipingui58.splindux.common.logger.SplinduxLogger;

public interface ICore {
	
	public abstract CosmeticManager getCosmeticManager();
	
	public abstract SplinduxLogger getSplinduxLogger();
	
	public abstract void loadListeners();
	
	public abstract void loadCommands();
	
	public abstract void load();
	
	public abstract void unload();
 
}
