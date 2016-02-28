package edu.nju.comparePrice.services;

import java.util.ArrayList;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.comparePrice.dao.CommentDaoStub;
import edu.nju.comparePrice.dao.DaoFacade;
import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.models.Navy;
import edu.nju.comparePrice.models.SensitiveWord;
import edu.nju.comparePrice.models.SpecialWord;
import edu.nju.comparePrice.models.User;


public class CommentService {
	@Autowired 
	private DaoFacade daoFacade;
	
	private static final int SENSITIVECOUNT=3;
	
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
	public ArrayList<Comment> getCommentsWithSpecialWord(){
		ArrayList<Comment> comments = daoFacade.getCommentsWithSpecialWord();
		return comments;
	}
	
	public void cancelSpecial(int commentId) {
		daoFacade.setSpecialFlag(commentId, false);
	}

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
				comment.setSpecialstate(true);;//set SpecialFlag
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
	
	public void addNavy(int userID){
		ArrayList<Navy> navyList=daoFacade.getNavyList();
		for(int i=0;i<navyList.size();i++){
			if(userID==navyList.get(i).getUid()){
				return ;
			}
		}
		daoFacade.addWaterNavy(userID);
	}
}

