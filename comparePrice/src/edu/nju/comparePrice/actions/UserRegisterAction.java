package edu.nju.comparePrice.actions;

import edu.nju.comparePrice.services.UserService;

public class UserRegisterAction extends BaseAction{
	private static final long serialVersionUID = -126741114733817207L;
	
	private int userId;
	
	private UserService userService;
	
	@Override
	public String execute() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		userId = userService.register(username, password);
		session.put("userId", userId);
		return SUCCESS;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
