package edu.nju.comparePrice.actions;

import java.io.IOException;

import edu.nju.comparePrice.services.SystemAdminService;

public class ForbidAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SystemAdminService systemAdminService;
	private int commodityId;
	
	public String execute() throws IOException{
		boolean result=systemAdminService.forbid(commodityId);
		if(result)
			response.getWriter().print("Y");
		else {
			response.getWriter().print("N");
		}
		return null;
	}

	public SystemAdminService getSystemAdminService() {
		return systemAdminService;
	}

	public void setSystemAdminService(SystemAdminService systemAdminService) {
		this.systemAdminService = systemAdminService;
	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	

}
