package edu.nju.comparePrice.actions;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.comparePrice.services.SynonymService;

public class SynonymImportAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SynonymService synonymService;

	public String execute() throws Exception {
		if(synonymService.importSynonym(file))
			return SUCCESS;
		return ERROR;
	}
	
	private File file;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
}
