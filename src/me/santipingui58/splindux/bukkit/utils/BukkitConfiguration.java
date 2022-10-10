package me.santipingui58.splindux.bukkit.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import org.bukkit.plugin.Plugin;
import me.santipingui58.splindux.common.io.config.AbstractConfiguration;



public class BukkitConfiguration extends AbstractConfiguration {
	
	private File file;
	private FileConfiguration fileConfig;
	
	
	/** Creates a new config at the path, with the fileName, and uses the Plugin */
	public BukkitConfiguration(String fileName, Plugin plugin) {
		if (!fileName.contains(".yml")) {
			fileName = fileName + ".yml";
		}
		file = new File(plugin.getDataFolder(), fileName);
		if(!file.exists()) {
			 file.getParentFile().mkdirs();
	            plugin.saveResource(fileName, false);
		} 
		
		fileConfig = new YamlConfiguration();
		
		try {
			fileConfig.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
		if (!file.exists()) {
			
			try {
				fileConfig.save(file);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
	
	/** Get the Configuration section */
	@Override
	public FileConfiguration getConfig() {
		return fileConfig;
	}
	
	/** Save the config */
	@Override
	public void saveConfig() {
		try {
			fileConfig.save(file);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public boolean saveOnUnload() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		
	}
	

}