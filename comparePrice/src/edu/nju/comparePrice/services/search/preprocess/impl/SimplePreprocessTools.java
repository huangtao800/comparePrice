package edu.nju.comparePrice.services.search.preprocess.impl;

import edu.nju.comparePrice.models.Synonym;
import edu.nju.comparePrice.services.search.preprocess.Checker;
import edu.nju.comparePrice.services.search.preprocess.Expander;
import edu.nju.comparePrice.services.search.preprocess.PreprocessTools;
import edu.nju.comparePrice.services.search.preprocess.Splitor;

public class SimplePreprocessTools implements PreprocessTools<Synonym> {
	
	@Override
	public Splitor createSplitor() {
		return new SimpleSplitor();
	}

	@Override
	public Checker createChecker() {
		return new SimpleChecker();
	}

	@Override
	public Expander<Synonym> createExpander() {
		return new SimpleExpander();
	}

}
