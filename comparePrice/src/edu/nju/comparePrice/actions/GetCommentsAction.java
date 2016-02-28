package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import org.apache.catalina.connector.Request;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.security.Init;

import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.services.CommentService;

public class GetCommentsAction extends BaseAction{
	private int cid;
	private CommentService service;
	private ArrayList<Comment> comments;
	

	public String execute() throws Exception {
		cid=Integer.parseInt(request.getParameter("cid"));
//		System.out.println("cid = "+cid);
		comments = service.getComments(cid);
		System.out.println("cid: "+cid);
		if(comments.isEmpty()){
			System.out.println("empty");
		}
		return "success";
//		if(comments.isEmpty()){
//			return "error";
//
//		}else {
//			return "success";
//		}
		
		
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
