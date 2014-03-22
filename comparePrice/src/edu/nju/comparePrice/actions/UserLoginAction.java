package edu.nju.comparePrice.actions;

import edu.nju.comparePrice.models.VerifyResult;
import edu.nju.comparePrice.services.UserService;

public class UserLoginAction extends BaseAction{
	
private static final long serialVersionUID = 897954802106607865L;
	
	private UserService userService;
	
	public String login() {
		String idString = request.getParameter("userId");
		String password = request.getParameter("password");

		VerifyResult verifyResult = userService.userVerify(idString, password);
		
		if (verifyResult == VerifyResult.PASS) {
			int id = Integer.parseInt(idString);
			session.put("userId", id);
			return SUCCESS;
		} else if (verifyResult == VerifyResult.ID_INVALID) {
			session.put("fail", "ID不存在！");
		} else if (verifyResult == VerifyResult.PASSWORD_INVALD){
			session.put("fail", "密码错误！");
		}
		return INPUT;
	}

	public String logout() {
		session.remove("userId");
		session.remove("fail");
		return SUCCESS;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
