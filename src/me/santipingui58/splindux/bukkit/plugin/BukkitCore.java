package me.santipingui58.splindux.bukkit.plugin;
import org.bukkit.plugin.Plugin;

import me.santipingui58.splindux.bukkit.listener.ChatListener;
import me.santipingui58.splindux.common.cosmetics.CosmeticManager;
import me.santipingui58.splindux.common.io.config.CoreConfig;
import me.santipingui58.splindux.common.plugin.SplinduxCore;

public class BukkitCore extends SplinduxCore {

	private Plugin plugin;
	
	private CosmeticManager cosmeticManager;
	
	
	public Plugin getPlugin() {
		return this.plugin;
	}
	
	
	public BukkitCore(Plugin plugin,CoreConfig coreConfig) {
		super(coreConfig);
		this.plugin = plugin;
	}
	
	@Override
	public CosmeticManager getCosmeticManager() {
		return this.cosmeticManager;
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
		plugin.getServer().getPluginManager().registerEvents(new ChatListener(), plugin);
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
