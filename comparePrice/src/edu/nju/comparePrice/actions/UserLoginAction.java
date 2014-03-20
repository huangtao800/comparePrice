package edu.nju.comparePrice.actions;

import com.sun.xml.internal.bind.v2.model.core.ID;

import edu.nju.comparePrice.models.BaseUser;
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
		} else if (verifyResult == VerifyResult.ID_INVALID) {
			session.put("fail", "ID不存在！");
		} else if (verifyResult == VerifyResult.PASSWORD_INVALD){
			session.put("fail", "密码错误！");
		}
		return verifyResult.toString();
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
