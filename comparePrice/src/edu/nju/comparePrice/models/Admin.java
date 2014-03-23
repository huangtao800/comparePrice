package edu.nju.comparePrice.models;

public class Admin extends BaseUser{
	private int id;
	private String password;
	
	public Admin(int id, String password) {
		super(id, password);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
