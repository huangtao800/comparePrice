package edu.nju.comparePrice.services;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import edu.nju.comparePrice.models.Admin;
import edu.nju.comparePrice.models.User;
import edu.nju.comparePrice.models.VerifyResult;

public class UserService {
	
	public User findUser(int userId) {
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
		
		User localUser = findUser(id);
		if (localUser == null) {
			return VerifyResult.ID_INVALID;
		}
		return verify(id, password, localUser.getId(), localUser.getPassword());
	}
	
	/**
	 * @return 用户id
	 */
	public int register(String username, String password) {
		return 123;
	}
	
	public Admin findAdmin(int adminId) {
		Admin admin = new Admin(123, "123");
		return admin;
	}
	
	public VerifyResult adminVerify(String idString, String password) {
		int id = 0;
		try {
			id = Integer.parseInt(idString);
		} catch (ParseException e) {
			return VerifyResult.ID_INVALID;
		}
		
		Admin localAdmin = findAdmin(id);
		if (localAdmin == null) {
			return VerifyResult.ID_INVALID;
		}
		return verify(id, password, localAdmin.getId(), localAdmin.getPassword());
	}
	
	private VerifyResult verify(int id, String inputPassword, int localId, String localPassword) {
		if (!inputPassword.equals(localPassword)) {
			return VerifyResult.PASSWORD_INVALD;
		} else {
			return VerifyResult.PASS;
		}
	}
}
