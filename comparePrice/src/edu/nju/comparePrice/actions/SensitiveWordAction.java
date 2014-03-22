package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.SensitiveWord;
import edu.nju.comparePrice.services.SystemAdminService;

public class SensitiveWordAction extends BaseAction{
	private SystemAdminService systemAdminService;
	private String sensitiveWord;
	private ArrayList<SensitiveWord> sensitiveWordList=new ArrayList<SensitiveWord>();

}
