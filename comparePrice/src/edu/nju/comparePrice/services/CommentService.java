package edu.nju.comparePrice.services;

import java.util.ArrayList;

public class CommentService {

	private static final int SENSITIVECOUNT=10;
	
	private static CommentService commentService;
	private ArrayList<String> sensitiveWords;	//initialized by DAOFacase
	private ArrayList<String> specialWords;		//initialized by DAOFacase

	private CommentService() {

	}

	public static CommentService getInstance() {
		if (commentService == null) {
			commentService = new CommentService();
		}
		return commentService;
	}

	public void postComment(int userID, String comment) {
		if(!checkComment(userID, comment)){
			//addComment
		}else{
			//detect water navy
		}
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
				
			return true;
		}
		return result;
	}

	public boolean checkWaterNavy(int userID) {
		int sensitiveCount=0;
		//获取用户的SensitiveCount
		return sensitiveCount>=SENSITIVECOUNT;
	}
}
