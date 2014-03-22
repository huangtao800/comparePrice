package edu.nju.comparePrice.services;

import java.util.ArrayList;

import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.models.SensitiveWord;

public class SystemAdminService {
	
	
	//获取已经被屏蔽的商品列表
	public ArrayList<Commodity> getForbiddenCommodities(){
		return null;
	}
	
	public ArrayList<Commodity> getToForbidCommodities(String commodityName){
		return null;
	}
	
	public boolean cancelForbid(int commodityId){
		return false;
	}
	
	public boolean forbid(int commodityId){
		return false;
	}
	
	public boolean addSensitiveWord(String sensitiveWord){
		return false;
	}
	
	public ArrayList<SensitiveWord> getSensiviveWordList(){
		return null;
	}
	
	public boolean removeSensitiveWord(int sensitiveWordId){
		return false;
	}
	
	public ArrayList<Brand> getBrandList(){
		return null;
	}
	
	public boolean saveBrand(int brandId,int brandWeight){
		return false;
	}

}
