package edu.nju.comparePrice.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import edu.nju.comparePrice.dao.DaoFacade;
import edu.nju.comparePrice.models.Synonym;

public class SynonymImporter {
	
	private DaoFacade daoFacade = DaoFacade.getInstance();
	
	private File file;
	private String splitor;
	
	public SynonymImporter(File file, String splitor) {
		this.file = file;
		this.splitor = splitor;
	}
	public SynonymImporter(File file) {
		this(file, "/");
	}
	
	public boolean process() {
		BufferedReader reader = null;
		String line = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {
				String[] keywords = line.split(splitor);
				addToSynonymDB(keywords);
			} 
		}catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	private boolean addToSynonymDB(String[] keywords) {
		int cmf = daoFacade.getCurrentMaxFlag();
		cmf++;
		for(String keyword : keywords) {
			Synonym syn = new Synonym(cmf, keyword);
			daoFacade.addSynonym(syn);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String path = "";
		File file = new File(path);
		SynonymImporter importer = new SynonymImporter(file);
		importer.process();
	}
}