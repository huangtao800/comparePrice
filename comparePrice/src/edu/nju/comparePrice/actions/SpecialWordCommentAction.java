package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.services.CommentService;

public class SpecialWordCommentAction extends BaseAction{
	private static final long serialVersionUID = 7961028231844262187L;
	
	private ArrayList<Comment> specialWordCommentList;
	
	private CommentService commentService;
	
	@Override
	public String execute() {
		specialWordCommentList = commentService.getCommentsWithSpecialWord();
		return SUCCESS;
	}
	
	public String delete() {
		String commentIdString = request.getParameter("commentId");
		int commentId = Integer.parseInt(commentIdString);
		commentService.cancelSpecial(commentId);
		return SUCCESS;
	}

	public ArrayList<Comment> getSpecialWordCommentList() {
		return specialWordCommentList;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	
}
