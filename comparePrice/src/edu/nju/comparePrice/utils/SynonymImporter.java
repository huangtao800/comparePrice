package edu.nju.comparePrice.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.comparePrice.dao.DaoFacade;
import edu.nju.comparePrice.models.Synonym;

public class SynonymImporter {
	
	@Autowired
	private DaoFacade dao;
	
	private String filepath;
	private String splitor;
	
	public SynonymImporter(String filepath, String splitor) {
		this.filepath = filepath;
		this.splitor = splitor;
	}
	public SynonymImporter(String filepath) {
		this(filepath, "/");
	}
	
	public boolean process() {
		BufferedReader reader = null;
		String line = null;
		try {
			reader = new BufferedReader(new FileReader(new File(filepath)));
			while((line = reader.readLine()) != null) {
				String[] keywords = line.split(splitor);
				addToSynonymDB(keywords);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
		int cmf = dao.getCurrentMaxFlag();
		cmf++;
		for(String keyword : keywords) {
			Synonym syn = new Synonym(cmf, keyword);
			dao.addSynonym(syn);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String path = "";
		SynonymImporter importer = new SynonymImporter(path);
		importer.process();
	}
}