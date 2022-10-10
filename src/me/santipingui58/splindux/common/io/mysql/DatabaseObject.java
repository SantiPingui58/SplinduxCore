package me.santipingui58.splindux.common.io.mysql;

public interface DatabaseObject {

	public void save();
	
	public void load();
	
	public boolean exists();
	
	public void create();
	
}
