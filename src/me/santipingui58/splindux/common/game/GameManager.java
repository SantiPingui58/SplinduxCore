package me.santipingui58.splindux.common.game;

import java.io.FileWriter;
import java.io.IOException;

import me.santipingui58.splindux.common.logger.Loggeable;
import me.santipingui58.splindux.common.manager.AbstractManager;
import me.santipingui58.splindux.common.manager.DataManager;
import me.santipingui58.splindux.common.plugin.SplinduxCore;

public class GameManager extends AbstractManager implements Loggeable,DataManager {

	private SplinduxCore core;
	
	public GameManager(SplinduxCore core) {
		this.core = core;
	}

	@Override
	public void info(String log) {
		FileWriter writer = core.getSplinduxLogger().getWriter();
		try {
			writer.write("["+getTimeFormat()+"] (" + GameManager.class.getCanonicalName() + "): "  +log );		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(String log) {
		// TODO Auto-generated method stub
		
	}




}
