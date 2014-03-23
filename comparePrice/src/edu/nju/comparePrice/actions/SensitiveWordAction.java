package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.SensitiveWord;
import edu.nju.comparePrice.services.SystemAdminService;

public class SensitiveWordAction extends BaseAction{
	private SystemAdminService systemAdminService;
	private String sensitiveWord;
	private ArrayList<SensitiveWord> sensitiveWordList=new ArrayList<SensitiveWord>();
	
	public String execute(){
		if(sensitiveWord!=null && !sensitiveWord.equals("")){
			boolean result=systemAdminService.addSensitiveWord(sensitiveWord);
		}
		
		sensitiveWordList=systemAdminService.getSensiviveWordList();
		return SUCCESS;
	}

	public SystemAdminService getSystemAdminService() {
		return systemAdminService;
	}

	public void setSystemAdminService(SystemAdminService systemAdminService) {
		this.systemAdminService = systemAdminService;
	}

	public String getSensitiveWord() {
		return sensitiveWord;
	}

	public void setSensitiveWord(String sensitiveWord) {
		this.sensitiveWord = sensitiveWord;
	}

	public ArrayList<SensitiveWord> getSensitiveWordList() {
		return sensitiveWordList;
	}

	public void setSensitiveWordList(ArrayList<SensitiveWord> sensitiveWordList) {
		this.sensitiveWordList = sensitiveWordList;
	}
	
	

}
