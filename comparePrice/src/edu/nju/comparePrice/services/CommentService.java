package edu.nju.comparePrice.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.comparePrice.dao.CommentDaoStub;
import edu.nju.comparePrice.dao.DaoFacade;
import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.models.SensitiveWord;
import edu.nju.comparePrice.models.SpecialWord;
import edu.nju.comparePrice.models.User;


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
	public ArrayList<Comment> getCommentsWithSpecialWord(){
		//桩
		ArrayList<Comment> comments = new ArrayList<>();
		Brand b1 = new Brand();
		Brand b2 = new Brand();
		b1.setName("腾讯");
		b2.setName("网易");
		Commodity a1= new Commodity(); 
		a1.setBrand(b1);
		Commodity a2= new Commodity(); 
		a2.setBrand(b2);
		User u1 =new User();
		Comment c1 = new Comment(a1,u1, "details1 adadaf" ,
				true,true,true);
		Comment c2 = new Comment(a2,u1, "details2 adadaf" ,
				true,true,true);
		comments.add(c1);
		comments.add(c2);
		return comments;
	}
	
	public ArrayList<SpecialWord> getSpecialWords(int id){
		//桩
		Brand brand2 = new Brand();
		brand2.setName("amazon");
		ArrayList<SpecialWord> specialWords = new ArrayList<>();
		SpecialWord s1 = new SpecialWord(brand2,"sb");
		SpecialWord s2 = new SpecialWord(brand2,"假冒");
		specialWords.add(s1);
		specialWords.add(s2);
		return specialWords;
		
	}
	
	public ArrayList<SpecialWord> getSpecialWordsList(){
		//桩
		Brand brand2 = new Brand();
		brand2.setName("amazon");
		ArrayList<SpecialWord> specialWords = new ArrayList<>();
		SpecialWord s1 = new SpecialWord(brand2,"sb");
		SpecialWord s2 = new SpecialWord(brand2,"假冒");
		specialWords.add(s1);
		specialWords.add(s2);
		return specialWords;
		
	}
	
	public void addSpecialWord(SpecialWord specialWord){
		System.out.println("add candidate word");
	}
	
	public void deleteSpecialWord(int specialWordId){
		System.out.println("delete candidate word " + specialWordId);
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

