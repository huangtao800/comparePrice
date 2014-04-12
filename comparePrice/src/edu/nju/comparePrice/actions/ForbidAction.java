package edu.nju.comparePrice.actions;

import java.io.IOException;

import edu.nju.comparePrice.services.SystemAdminService;

public class ForbidAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SystemAdminService systemAdminService;
	
	
	public String execute() {
		int commodityId=Integer.parseInt( request.getParameter("commodityId") );
		boolean result=systemAdminService.forbid(commodityId);
		if(result)
			return "Forbid";
		else {
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
