package edu.nju.comparePrice.services.search.preprocess;

public interface PreprocessTools {
	Splitor createSplitor();
	Checker createChecker();
	Expander createExpander();
}
