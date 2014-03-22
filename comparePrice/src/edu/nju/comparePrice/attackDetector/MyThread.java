package edu.nju.comparePrice.attackDetector;

public class MyThread extends Thread{

	private IPList ipList;
	private long time;
	public MyThread(IPList iplist, long t)
	{
		time = t;
		ipList = iplist;
	}
	
	public void run()
	{
		while(true)
		{
		try{
		Thread.sleep(time);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ipList.clear();
		}
	}
}
