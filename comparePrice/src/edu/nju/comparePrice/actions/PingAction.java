package edu.nju.comparePrice.actions;

import java.awt.print.Printable;
import java.io.IOException;

public class PingAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private BankCustomerService  bankCustomerService;
	public String execute() throws IOException{
		System.out.println("received");
	    response.getWriter().print("Yes");
		return null;
		
	}
//	public BankCustomerService getBankCustomerService() {
//		return bankCustomerService;
//	}
//	public void setBankCustomerService(BankCustomerService bankCustomerService) {
//		this.bankCustomerService = bankCustomerService;
//	}
	

}
