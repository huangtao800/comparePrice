package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.services.SystemAdminService;

public class BeforeForbidAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SystemAdminService systemAdminService;
	private String commodityName;
	ArrayList<Commodity> toForbidList=new ArrayList<Commodity>();
	ArrayList<Commodity> forbiddenList=new ArrayList<Commodity>();
	
	public String execute(){
		forbiddenList=systemAdminService.getForbiddenCommodities();
		if(commodityName!=null && !commodityName.equals("")){
			toForbidList=systemAdminService.getToForbidCommodities(commodityName);
		}
		
		return "forbidCommodity";
		
	}

	public SystemAdminService getSystemAdminService() {
		return systemAdminService;
	}

	public void setSystemAdminService(SystemAdminService systemAdminService) {
		this.systemAdminService = systemAdminService;
	}



	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public ArrayList<Commodity> getToForbidList() {
		return toForbidList;
	}

	public void setToForbidList(ArrayList<Commodity> toForbidList) {
		this.toForbidList = toForbidList;
	}

	public ArrayList<Commodity> getForbiddenList() {
		return forbiddenList;
	}

	public void setForbiddenList(ArrayList<Commodity> forbiddenList) {
		this.forbiddenList = forbiddenList;
	}
	

}
