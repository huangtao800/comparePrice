package edu.nju.comparePrice.attackDetector;

import java.util.ArrayList;

public class IPList {

	private ArrayList<String> ipList = new ArrayList<String>();
	
	public synchronized void add(String ip)
	{
		ipList.add(ip);
	}
	
	public int size()
	{
		return ipList.size();
	}
	public boolean contains(String ip)
	{
		return ipList.contains(ip);
	}
	
	public synchronized void clear()
	{
		ipList.clear();
	}
	
	public int getTimes(String ip)
	{
		int number  = 0;
		for(int i = 0; i < ipList.size(); ++i)
		{
			if(ip.equals(ipList.get(i)))
				++number;
		}
		return number;
	}
	
}
