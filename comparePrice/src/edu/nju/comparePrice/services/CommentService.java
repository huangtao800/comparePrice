package edu.nju.comparePrice.services;

import java.util.ArrayList;

import edu.nju.comparePrice.dao.CommentDaoStub;
import edu.nju.comparePrice.dao.DaoFacade;
import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.models.SensitiveWord;
import edu.nju.comparePrice.models.SpecialWord;


public class CommentService {

	private static final int SENSITIVECOUNT=10;
	
	private ArrayList<SensitiveWord> sensitiveWords=new ArrayList<SensitiveWord>();	//should be initialized by DAOFacase
	private ArrayList<SpecialWord> specialWords =new ArrayList<SpecialWord>();		//should be initialized by DAOFacase

	private CommentDaoStub dao;
	private DaoFacade daoFacade;
	
	public CommentService(){
		this.daoFacade=new DaoFacade();
		sensitiveWords=daoFacade.getSensitiveWords();
		specialWords=daoFacade.getSpecialWords();
		
	}
	
	public boolean addComment(Comment comment){
		dao.addComment(comment);
		return true;
	}
	
	
	public ArrayList<Comment> getComments(int cid){
		return dao.getComments(cid);
	}

	public CommentDaoStub getDao() {
		return dao;
	}

	public void setDao(CommentDaoStub dao) {
		this.dao = dao;
	}


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
			if(comment.contains(sensitiveWords.get(i).getName())){
				daoFacade.addSentsitiveCount(userID, 1);//add sensitiveCount
				//set sensitiveFlag
				result=true;
			}
				
		}
		
		for(int i=0;i<specialWords.size();i++){
			if(comment.contains(specialWords.get(i).getName())){
				//set SpecialFlag
				result=true;
			}
			
		}
		return result;
	}

	public boolean checkWaterNavy(int userID) {
		int sensitiveCount=0;
		sensitiveCount=daoFacade.getSensitiveCountByUseID(userID);//add sensitiveCount
		return sensitiveCount>=SENSITIVECOUNT;
	}
	
}

