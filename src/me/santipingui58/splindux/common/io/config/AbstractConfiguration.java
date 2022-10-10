package me.santipingui58.splindux.common.io.config;

public abstract class AbstractConfiguration {

	public abstract Object getConfig();
	
	public abstract void saveConfig();
	
	public abstract boolean saveOnUnload();
	
	public abstract void reload();
	
}
