package edu.nju.comparePrice.actions;

import java.io.IOException;

import edu.nju.comparePrice.services.SystemAdminService;

public class CancelForbidAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SystemAdminService systemAdminService;
	
	
	public String execute() throws IOException{
		int commodityId=Integer.parseInt( request.getParameter("commodityId") );
		boolean result=systemAdminService.cancelForbid(commodityId);
		if(result)
		    return "Success";
		else 
			return "input";
	}

	public SystemAdminService getSystemAdminService() {
		return systemAdminService;
	}

	public void setSystemAdminService(SystemAdminService systemAdminService) {
		this.systemAdminService = systemAdminService;
	}
	

}
