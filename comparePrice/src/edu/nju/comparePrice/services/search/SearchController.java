package edu.nju.comparePrice.services.search;

import java.util.List;

import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.services.search.lexicon.LexiconSearcher;
import edu.nju.comparePrice.services.search.preprocess.Preprocessor;
import edu.nju.comparePrice.services.search.preprocess.impl.SimplePreprocessTools;

public class SearchController {
	
	private Preprocessor preprocessor;
	private LexiconSearcher lexiconSearcher;
	
	public SearchController() {
		preprocessor = new Preprocessor(new SimplePreprocessTools());
		lexiconSearcher = new LexiconSearcher();
	}
	
	public List<Commodity> search(String keyword) {
		return lexiconSearcher.lookup(
					preprocessor.preprocess(keyword));
	}
}
