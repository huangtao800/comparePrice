package edu.nju.comparePrice.attackDetector;

public class AttackDetector {

	private Writer writer = new Writer();
	private Block block = new Block();
	private IPList ipList = new IPList();
	private IPList shieldList = new IPList();
	private Free whiteList = new Free();
	private final int NUMBER = 5;
	
	public AttackDetector()
	{
		startThread();
	}
	public boolean analyzeIP(String IP)
	{
		if(!whiteList.isFree(IP))//���ip���ڰ�����
		{
			writer.write(IP);  //��ÿһ�η��ʵ�IP��¼��log�ļ���
		if(block.isBlock(IP) || shieldList.contains(IP)) // �жϸ�IP�ǲ��������������棬����ǲ��������
		{
			System.out.println("被屏蔽");
			return false;
		}
		else if(ipList.contains(IP))
		{
			ipList.add(IP);
			System.out.println("频繁访问");
			int number = ipList.getTimes(IP);
			System.out.println(number);
			if(number >= NUMBER)//����Ƶ�����ʵĴ������Ԥ���Ĵ����������һ��ʱ���Ժ���ܼ������
			{
			   shieldList.add(IP);
			}
			return false;
		}
		else
		{
			System.out.println(IP + "  访问成功");//�������
			ipList.add(IP);
			return true;
		}
	    }
		else
		{
			System.out.println(IP + "   访问成功");
			  return true;   //�������
		}
	}
	
	private void startThread()
	{
		MyThread ipListThread = new MyThread(ipList, 1000);
	     ipListThread.start();
	    
	    MyThread shieldListThread = new MyThread(shieldList, 1800000);
	    shieldListThread.start();
	}
}
