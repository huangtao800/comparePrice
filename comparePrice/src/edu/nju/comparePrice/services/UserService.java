package edu.nju.comparePrice.services;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import edu.nju.comparePrice.models.User;
import edu.nju.comparePrice.models.VerifyResult;

public class UserService {
	
	public User find(int userId) {
		User user = new User(123, "123","123");
		return user;
	}
	
	public VerifyResult userVerify(String idString, String password) {
		int id = 0;
		try {
			id = Integer.parseInt(idString);
		} catch (ParseException e) {
			return VerifyResult.ID_INVALID;
		}
		
		
		User localUser = find(id);
		if (localUser == null) {
			return VerifyResult.ID_INVALID;
		} else if (!password.equals(localUser.getPassword())) {
			return VerifyResult.PASSWORD_INVALD;
		} else {
			return VerifyResult.PASS;
		}
	}
	
	/**
	 * @return 用户id
	 */
	public int register(String username, String password) {
		return 123;
	}
}
