package edu.nju.comparePrice.services.search.preprocess.impl;

import java.util.List;

import edu.nju.comparePrice.services.search.preprocess.Checker;

public class SimpleChecker implements Checker {

	@Override
	public List<String> check(List<String> keywords) {
		return keywords;
	}

}
