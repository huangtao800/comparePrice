package edu.nju.comparePrice.services.search.preprocess;

import java.util.List;

public interface Expander<T> {
	List<T> expander(List<String> keywords);
}
