package edu.nju.comparePrice.services.search.preprocess;

import java.util.List;

public class Preprocessor<T> {
	
	private PreprocessTools<T> tools;
	
	public Preprocessor(PreprocessTools<T> tools) {
		this.tools = tools;
	}
	
	public List<T> preprocess(String keyword) {
		return tools.createExpander().expander(
					tools.createChecker().check(
						tools.createSplitor().split(keyword)));
	}
}
