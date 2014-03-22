package edu.nju.comparePrice.actions;

import java.util.ArrayList;
import edu.nju.comparePrice.services.SystemAdminService;

public class SaveBrandsAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SystemAdminService systemAdminService;
//	private ArrayList<Brand> brandList=new ArrayList<Brand>();
	private ArrayList<Integer> brandId;
	private ArrayList<Integer> brandWeight;
	public String execute(){
		if(brandId!=null && brandWeight!=null){
			for(int i=0;i<brandId.size();i++){
				int id=brandId.get(i);
				int weight=brandId.get(i);
				boolean result=systemAdminService.saveBrand(id, weight);
				if(!result){
					return "input";
				}
			}
		}
		return "brandWeight"; 
	}
	
	public SystemAdminService getSystemAdminService() {
		return systemAdminService;
	}
	public void setSystemAdminService(SystemAdminService systemAdminService) {
		this.systemAdminService = systemAdminService;
	}

	public ArrayList<Integer> getBrandId() {
		return brandId;
	}

	public void setBrandId(ArrayList<Integer> brandId) {
		this.brandId = brandId;
	}

	public ArrayList<Integer> getBrandWeight() {
		return brandWeight;
	}

	public void setBrandWeight(ArrayList<Integer> brandWeight) {
		this.brandWeight = brandWeight;
	}

	

}
