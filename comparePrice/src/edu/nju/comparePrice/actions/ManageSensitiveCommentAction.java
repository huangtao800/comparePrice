package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.services.SystemAdminService;

public class ManageSensitiveCommentAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SystemAdminService systemAdminService;
	private ArrayList<Comment> sensitiveCommentList=new ArrayList<Comment>();
	private String commentDetails;
	private int commentID;
	
	public String execute(){
		sensitiveCommentList=systemAdminService.getSensitiveCommentList();
		return "SensitiveComment";
	}
	
	public String save(){
		boolean result=systemAdminService.editSensitiveComment(commentID, commentDetails);
		if(result)
			return "";
		else {
			return "input";
		}
	}
	
	public String delete(){
		boolean result=systemAdminService.deleteSensitiveComment(commentID);
		if(result)
			return "";
		else
			return "input";
	}

	public SystemAdminService getSystemAdminService() {
		return systemAdminService;
	}

	public void setSystemAdminService(SystemAdminService systemAdminService) {
		this.systemAdminService = systemAdminService;
	}

	public ArrayList<Comment> getSensitiveCommentList() {
		return sensitiveCommentList;
	}

	public void setSensitiveCommentList(ArrayList<Comment> sensitiveCommentList) {
		this.sensitiveCommentList = sensitiveCommentList;
	}

	public String getCommentDetails() {
		return commentDetails;
	}

	public void setCommentDetails(String commentDetails) {
		this.commentDetails = commentDetails;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	

}
