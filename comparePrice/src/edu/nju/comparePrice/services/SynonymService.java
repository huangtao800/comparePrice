package edu.nju.comparePrice.services;

import java.io.File;

import edu.nju.comparePrice.utils.SynonymImporter;

public class SynonymService {
	
	public boolean importSynonym(File file) {
		SynonymImporter importer = new SynonymImporter(file);
		return importer.process();
	}
	
}
