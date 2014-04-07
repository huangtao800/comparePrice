package edu.nju.comparePrice.services.search.preprocess;

import java.util.List;

public interface Expander {
	List<List<String>> expander(List<String> keywords);
}
