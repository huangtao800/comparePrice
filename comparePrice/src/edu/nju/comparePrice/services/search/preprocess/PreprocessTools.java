package edu.nju.comparePrice.services.search.preprocess;

public interface PreprocessTools<T> {
	Splitor createSplitor();
	Checker createChecker();
	Expander<T> createExpander();
}
