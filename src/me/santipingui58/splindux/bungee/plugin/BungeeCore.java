package me.santipingui58.splindux.bungee.plugin;

import me.santipingui58.splindux.bungee.listener.PlayerLoginListener;
import me.santipingui58.splindux.common.io.config.CoreConfig;
import me.santipingui58.splindux.common.plugin.SplinduxCore;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeCore extends SplinduxCore {

	private Plugin plugin;
	
	
	public Plugin getPlugin() {
		return this.plugin;
	}
	
	
	public BungeeCore(Plugin plugin,CoreConfig coreConfig) {
		super(coreConfig);
		this.plugin = plugin;
	}
	

	@Override
	public void info(String log) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void warn(String log) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void loadListeners() {
		plugin.getProxy().getPluginManager().registerListener(plugin, new PlayerLoginListener(plugin));
	}


	@Override
	public void loadCommands() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void unload() {
		// TODO Auto-generated method stub
		
	}


}
