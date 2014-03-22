package edu.nju.comparePrice.actions;

import java.io.IOException;

import javax.servlet.ServletException;

import edu.nju.comparePrice.models.User;
import edu.nju.comparePrice.services.UserService;

public class UserBarAction extends BaseAction{
	private static final long serialVersionUID = 5144563963912658234L;
	
	private int id;
	private User user;
	
	private UserService userService;

	/** (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * 判断用户是否登录，如果登录，就给界面用户的信息
	 */
	@Override
	public String execute () throws ServletException, IOException {
		Integer id = (Integer) session.get("userId");
		if (id == null) {
			return "notLogon";
		} else {
			this.id = id;
			this.user = userService.find(id);
			return "logon";
		}
		
	}
	
	public int getId () {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
