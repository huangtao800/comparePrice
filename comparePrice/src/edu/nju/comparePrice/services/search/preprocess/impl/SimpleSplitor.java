package edu.nju.comparePrice.services.search.preprocess.impl;

import java.util.Arrays;
import java.util.List;

import edu.nju.comparePrice.services.search.preprocess.Splitor;

public class SimpleSplitor implements Splitor {

	@Override
	public List<String> split(String keyword) {
		return Arrays.asList(keyword.split(" "));
	}
}
