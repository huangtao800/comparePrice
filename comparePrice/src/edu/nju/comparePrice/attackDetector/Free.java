package edu.nju.comparePrice.attackDetector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Free {

	private IPList whiteList;
	
	public Free()
	{
		whiteList = new IPList();
		init();
	}
	
	public boolean isFree(String ip)
	{
		return whiteList.contains(ip);
	}
	
	public void init()
	{
		try{
			String path = this.getClass().getClassLoader().getResource("/").getPath();
			File file = new File(path + "whiteList.txt");
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader read = new BufferedReader(reader);
			
			String line = "";
			while((line = read.readLine()) != null)
			{
				whiteList.add(line);
			}
			
			read.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
}
