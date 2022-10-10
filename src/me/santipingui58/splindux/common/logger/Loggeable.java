package me.santipingui58.splindux.common.logger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public interface Loggeable {


	public void info(String log);
	
	public void warn(String log);
	

	
	public default String getTimeFormat() {
		LocalTime time = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
		time.format(formatter);
		return time.toString();
	}

	
	
}
