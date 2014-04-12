package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.Navy;
import edu.nju.comparePrice.services.SystemAdminService;

public class CheckNavyAction extends BaseAction{
	private SystemAdminService systemAdminService;
	private ArrayList<Navy> navyList=new ArrayList<Navy>();
	
	public String execute(){
		navyList=systemAdminService.getNavyList();
		return "CheckNavy";	
	}

	public SystemAdminService getSystemAdminService() {
		return systemAdminService;
	}

	public void setSystemAdminService(SystemAdminService systemAdminService) {
		this.systemAdminService = systemAdminService;
	}

	public ArrayList<Navy> getNavyList() {
		return navyList;
	}

	public void setNavyList(ArrayList<Navy> navyList) {
		this.navyList = navyList;
	}
	

}
