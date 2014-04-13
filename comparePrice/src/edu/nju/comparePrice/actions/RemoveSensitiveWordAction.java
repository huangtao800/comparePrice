package edu.nju.comparePrice.actions;

import java.io.IOException;

import edu.nju.comparePrice.services.SystemAdminService;

public class RemoveSensitiveWordAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SystemAdminService systemAdminService;
	//private String sensitiveId;
	
	public String execute() throws IOException{
		int sid=-1;
		String sensitiveId = request.getParameter("sensitiveId");
		try {
			sid=Integer.parseInt(sensitiveId);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("传递的敏感词id出错！   "+sensitiveId);
			 return "input";
		}
		
		boolean result=systemAdminService.removeSensitiveWord(sid);
		if(result){
			System.out.println("删除敏感词成功！"+sid);
			return "SensitiveWord";
		}
		else {
			 System.out.println("删除敏感词失败！"+sid);
			 return "input";
		}
		
	}

	public SystemAdminService getSystemAdminService() {
		return systemAdminService;
	}

	public void setSystemAdminService(SystemAdminService systemAdminService) {
		this.systemAdminService = systemAdminService;
	}

}
