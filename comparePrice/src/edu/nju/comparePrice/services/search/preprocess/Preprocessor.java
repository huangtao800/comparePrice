package edu.nju.comparePrice.services.search.preprocess;

import java.util.List;

public class Preprocessor {
	
	private PreprocessTools tools;
	
	public Preprocessor(PreprocessTools tools) {
		this.tools = tools;
	}
	
	public List<List<String>> preprocess(String keyword) {
		return tools.createExpander().expander(
					tools.createChecker().check(
						tools.createSplitor().split(keyword)));
	}
}
