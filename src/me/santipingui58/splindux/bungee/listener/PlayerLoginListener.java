package me.santipingui58.splindux.bungee.listener;

import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;



public class PlayerLoginListener implements Listener {

	private Plugin plugin;
	
	public PlayerLoginListener(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PostLoginEvent e) {
		plugin.getProxy();
	}
	
}
