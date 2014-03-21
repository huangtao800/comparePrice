package edu.nju.comparePrice.attackDetector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Block {

	private ArrayList<String> blockList;
	
	public Block()
	{
		blockList = new ArrayList<String>();
		init();
	}
	
	private void init()
	{
		try{
		File file = new File("����IP.txt");
		InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
		BufferedReader read = new BufferedReader(reader);
		
		String line = "";
		while((line = read.readLine()) != null)
		{
			blockList.add(line);
		}
		
		read.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public boolean isBlock(String IP)
	{
		for(int i = 0; i < blockList.size(); ++i)
		{
			if(IP.equals(blockList.get(i)))
			{
				return true;
			}
		}
		
		return false;
	}
}
