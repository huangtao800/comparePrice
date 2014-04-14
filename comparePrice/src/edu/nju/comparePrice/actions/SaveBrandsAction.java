package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.Out;

import edu.nju.comparePrice.services.SystemAdminService;

public class SaveBrandsAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SystemAdminService systemAdminService;
	private int brandId;
	private int brandWeight;
	public String execute(){
//		int id=0;
//		int weight=0;
//		try {
//			id=Integer.parseInt(request.getParameter("id"));
//			weight=Integer.parseInt(request.getParameter("weight"));
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("id:"+id+"  weight:"+weight);
//			return "input";
//		}
		
//		if(brandId!=null && brandWeight!=null){
//			for(int i=0;i<brandId.size();i++){
//				int id=brandId.get(i);
//				int weight=brandWeight.get(i);
//				System.out.println(id+" -- "+weight);
				boolean result=systemAdminService.saveBrand(brandId, brandWeight);
				if(!result){
					return "input";
				}
//			}
//		}
		return "success"; 
	}
	
	public SystemAdminService getSystemAdminService() {
		return systemAdminService;
	}
	public void setSystemAdminService(SystemAdminService systemAdminService) {
		this.systemAdminService = systemAdminService;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getBrandWeight() {
		return brandWeight;
	}

	public void setBrandWeight(int brandWeight) {
		this.brandWeight = brandWeight;
	}

//	public ArrayList<Integer> getBrandId() {
//		return brandId;
//	}
//
//	public void setBrandId(ArrayList<Integer> brandId) {
//		this.brandId = brandId;
//	}
//
//	public ArrayList<Integer> getBrandWeight() {
//		return brandWeight;
//	}
//
//	public void setBrandWeight(ArrayList<Integer> brandWeight) {
//		this.brandWeight = brandWeight;
//	}

	

}
