package edu.nju.comparePrice.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.comparePrice.dao.CommentDaoStub;
import edu.nju.comparePrice.dao.DaoFacade;
import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.models.SensitiveWord;
import edu.nju.comparePrice.models.SpecialWord;


public class CommentService {
	@Autowired 
	private DaoFacade daoFacade;
	
	private static final int SENSITIVECOUNT=10;
	
			//should be initialized by DAOFacase


	//private CommentDaoStub dao;
	
//	public CommentService(){
//		this.daoFacade=new DaoFacade();
//		sensitiveWords=daoFacade.getSensitiveWords();
//		specialWords=daoFacade.getSpecialWords();
//		
//	}
	
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


//	public boolean postComment(int userID, Comment comment) {
//		boolean result=false;
//		if(!checkComment(userID, comment)){
//			daoFacade.addComment(comment);//addComment
//		}else{
//			checkWaterNavy(userID);//detect water navy
//			result=true;
//		}
//		return result;
//	}

	public boolean checkComment(int userID, Comment comment) {
		ArrayList<SensitiveWord> sensitiveWords=daoFacade.getSensitiveWords();	//should be initialized by DAOFacase
		ArrayList<SpecialWord> specialWords =daoFacade.getSpecialWords();
		boolean result =false;
		for(int i=0;i<sensitiveWords.size();i++){
			if(comment.getDetails().contains(sensitiveWords.get(i).getName())){
				daoFacade.addSentsitiveCount(userID, 1);//add sensitiveCount
				comment.setState(true);//set sensitiveFlag
				result=true;
			}
				
		}
		
		for(int i=0;i<specialWords.size();i++){
			if(comment.getDetails().contains(specialWords.get(i).getName())){
				comment.setIscandidateword(true);;//set SpecialFlag
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

