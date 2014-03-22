package edu.nju.comparePrice.actions;

import java.io.IOException;

import edu.nju.comparePrice.services.SystemAdminService;

public class RemoveSensitiveWordAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SystemAdminService systemAdminService;
	private int sensitiveId;
	
	public String execute() throws IOException{
		boolean result=systemAdminService.removeSensitiveWord(sensitiveId);
		if(result)
		     response.getWriter().println("Y");
		else {
			 response.getWriter().println("N");
		}
		return null;
	}

	public SystemAdminService getSystemAdminService() {
		return systemAdminService;
	}

	public void setSystemAdminService(SystemAdminService systemAdminService) {
		this.systemAdminService = systemAdminService;
	}

	public int getSensitiveId() {
		return sensitiveId;
	}

	public void setSensitiveId(int sensitiveId) {
		this.sensitiveId = sensitiveId;
	}
	
	

}
