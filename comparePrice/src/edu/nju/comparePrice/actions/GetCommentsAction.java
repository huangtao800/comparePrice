package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.security.Init;

import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.services.CommentService;

public class GetCommentsAction extends ActionSupport{
	private int cid;
	private CommentService service;
	private ArrayList<Comment> comments;
	

	public String execute() throws Exception {
		comments = service.getComments(cid);
		if(comments.isEmpty()){
			return ERROR;

		}else {
			return SUCCESS;
		}
		
	}


	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCid() {
		return cid;
	}

	
	public CommentService getService() {
		return service;
	}

	public void setService(CommentService service) {
		this.service = service;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	
	
}
