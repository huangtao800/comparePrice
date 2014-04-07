package edu.nju.comparePrice.dao;

import java.util.ArrayList;

import edu.nju.comparePrice.models.Comment;


public class CommentDaoStub {
	private ArrayList<Comment> list = new ArrayList<Comment>();
	
	public CommentDaoStub(){
		makeList();
	}

	public boolean addComment(Comment c){
		System.out.println(c.toString()+"     .....is adding");
		list.add(c);
		return true;
	}
	
	
	public ArrayList<Comment> getComments(int cid){
		return list;
	}
	
	
	private void makeList(){
		for(int i=0;i<10;i++){
			Comment comment = new Comment();
//			comment.setCid(i);
//			comment.setUid((int)(100*Math.random()));
			comment.setDetails("This is the Test Content..."+i+i+i+"!!!!!!!");
			comment.setState(false);
			list.add(comment);
		}
	}
}
