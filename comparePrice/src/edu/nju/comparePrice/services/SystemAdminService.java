package edu.nju.comparePrice.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.comparePrice.dao.DaoFacade;
import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.models.Navy;
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
	
	//获得水军列表，即navy表中的说有数据
	public ArrayList<Navy> getNavyList(){
		return null;
	}
	
	//获得敏感评论列表
	public ArrayList<Comment> getSensitiveCommentList(){
		return null;
	}
	
	//给定评论的id，删除该评论
	public boolean deleteSensitiveComment(int cid){
		return true;
	}
	
	//修改评论。给定评论id和评论的details，保存detail
	public boolean editSensitiveComment(int cid,String details){
		return true;
	}
	
	//给定评论id，返回该评论
	public Comment getCommentById(int commentId){
		return null;
	}
	
	
	
	

}
