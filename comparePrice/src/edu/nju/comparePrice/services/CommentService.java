package edu.nju.comparePrice.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.comparePrice.dao.CommentDaoStub;
import edu.nju.comparePrice.dao.DaoFacade;
import edu.nju.comparePrice.models.Comment;


public class CommentService {
	@Autowired 
	private DaoFacade daoFacade;
	
	private static final int SENSITIVECOUNT=10;
	
	private ArrayList<String> sensitiveWords=new ArrayList<String>();	//should be initialized by DAOFacase
	private ArrayList<String> specialWords =new ArrayList<String>();		//should be initialized by DAOFacase

	//private CommentDaoStub dao;
	
	public CommentService(){
	}
	
	public boolean addComment(Comment comment){
		daoFacade.addComment(comment);
		return true;
	}
	
	
	public ArrayList<Comment> getComments(int cid){
		return daoFacade.getComments(cid);
	}

//	public CommentDaoStub getDao() {
//		return daoFacade;
//	}
//
//	public void setDao(CommentDaoStub dao) {
//		this.daoFacade = dao;
//	}


	public boolean postComment(int userID, String comment) {
		boolean result=false;
		if(!checkComment(userID, comment)){
			//addComment
		}else{
			//detect water navy
			result=true;
		}
		return result;
	}

	public boolean checkComment(int userID, String comment) {
		boolean result =false;
		for(int i=0;i<sensitiveWords.size();i++){
			if(comment.contains(sensitiveWords.get(i))){
				//add sensitiveCount
				//set sensitiveFlag
				result=true;
			}
				
		}
		
		for(int i=0;i<specialWords.size();i++){
			if(comment.contains(specialWords.get(i))){
				//set SpecialFlag
				result=true;
			}
			
		}
		return result;
	}

	public boolean checkWaterNavy(int userID) {
		int sensitiveCount=0;
		//add sensitiveCount
		return sensitiveCount>=SENSITIVECOUNT;
	}
	
}

