package edu.nju.comparePrice.actions;


import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.models.User;
import edu.nju.comparePrice.services.CommentService;

public class AddCommentAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869198100114733155L;
	private Comment comment;
	private CommentService service;

	public String execute() throws Exception {
		Integer id = (Integer) session.get("userId");
		if(id==null){
			return "toLogin";
		}else{
			User user = new User();
			user.setId(id);
			comment.setUser(user);
			// set all states false
			comment.setIscandidateword(false);
			comment.setSpecialstate(false);
			comment.setState(false);
		
		}
		
		if(service.checkWaterNavy(id)){
//			service.addComment(comment);
			return "badComment";
		}
		
		if(service.checkComment(id, comment)){
			service.addComment(comment);
			return "badComment";
		}else{
			service.addComment(comment);
			return "goodComment";
		}

	}
	

	public Comment getComment() {
		return comment;
	}


	public void setComment(Comment comment) {
		this.comment = comment;
	}


	public CommentService getService() {
		return service;
	}


	public void setService(CommentService service) {
		this.service = service;
	}

}
