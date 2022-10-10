package me.santipingui58.splindux.common.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class SplinduxLogger  {

	
	private File file;
	private FileWriter writer;
	
	
	public SplinduxLogger(String path) {
		
		LocalDate date = LocalDate.now();
		int logNumber = 0;
		 file = new File(path+date.toString()+"-"+logNumber+"_splindux.log");
		
		try {
			while (!file.createNewFile()) {
				logNumber++;
				file = new File(path+date.toString()+"-"+logNumber+"_splindux.log");
			}
			
			writer = new FileWriter(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public FileWriter getWriter() {
		return this.writer;
	}
	
	public File getFile() {
		return this.file;
	}

}
