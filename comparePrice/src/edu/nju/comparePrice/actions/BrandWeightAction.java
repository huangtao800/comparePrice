package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.services.SystemAdminService;

public class BrandWeightAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SystemAdminService systemAdminService;
	private ArrayList<Brand> brandList=new ArrayList<Brand>();
	
	public String execute(){
		brandList=systemAdminService.getBrandList();
		return SUCCESS;
	}

	public SystemAdminService getSystemAdminService() {
		return systemAdminService;
	}

	public void setSystemAdminService(SystemAdminService systemAdminService) {
		this.systemAdminService = systemAdminService;
	}

	public ArrayList<Brand> getBrandList() {
		return brandList;
	}

	public void setBrandList(ArrayList<Brand> brandList) {
		this.brandList = brandList;
	}
	
	

}
