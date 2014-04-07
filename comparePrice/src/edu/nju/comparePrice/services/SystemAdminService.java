package edu.nju.comparePrice.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.comparePrice.dao.DaoFacade;
import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.models.SensitiveWord;


public class SystemAdminService {
	@Autowired 
	private DaoFacade daoFacade;	
	
	//获取已经被屏蔽的商品列表
	public ArrayList<Commodity> getForbiddenCommodities(){
		return daoFacade.getForbiddenCommodities();
	}
	
	public ArrayList<Commodity> getToForbidCommodities(String commodityName){
		return daoFacade.getToForbidCommodities(commodityName);
	}
	
	public boolean cancelForbid(int commodityId){
		return daoFacade.cancelForbid(commodityId);
	}
	
	public boolean forbid(int commodityId){
		return daoFacade.forbid(commodityId);
	}
	
	public boolean addSensitiveWord(String sensitiveWord){
		return daoFacade.addSensitiveWord(sensitiveWord);
	}
	
	public ArrayList<SensitiveWord> getSensiviveWordList(){
		return daoFacade.getSensiviveWordList();
	}
	
	public boolean removeSensitiveWord(int sensitiveWordId){
		return daoFacade.removeSensitiveWord(sensitiveWordId);
	}
	
	public ArrayList<Brand> getBrandList(){
		return daoFacade.getBrandList();
	}
	
	public boolean saveBrand(int brandId,int brandWeight){
		return daoFacade.saveBrand(brandId, brandWeight);
	}

}
