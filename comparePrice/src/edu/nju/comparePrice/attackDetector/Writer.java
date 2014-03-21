package edu.nju.comparePrice.attackDetector;

import java.io.*;
import java.text.DateFormat;
import java.util.Locale;

public class Writer {

	private File file;
	
	
	public void write(String IP)
	{
		try{
			file = new File("log.txt"); 
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
