package edu.nju.comparePrice.attackDetector;

import java.io.*;
import java.text.DateFormat;
import java.util.Locale;

public class Writer {

	private File file;
	
	
	public void write(String IP)
	{
		try{
			String path = this.getClass().getClassLoader().getResource("/").getPath();
			file = new File(path + "log.txt");
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true)); 
            
            String time = DateFormat.getDateTimeInstance(2, 2, Locale.CHINESE).format(new java.util.Date());
            out.write(IP + "   " + time + "\r\n");   
            out.flush();   
            out.close(); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}