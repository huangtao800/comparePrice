package edu.nju.comparePrice.services.search.preprocess.impl;

import java.util.ArrayList;
import java.util.List;

import edu.nju.comparePrice.services.search.preprocess.Expander;

public class SimpleExpander implements Expander {

	@Override
	public List<List<String>> expander(List<String> keywords) {
		List<List<String>> result = new ArrayList<List<String>>();
		for(String keyword : keywords) {
			List<String> list = new ArrayList<String>();
			list.add(keyword);
			list.addAll(getSynoym(keyword));
			result.add(list);
		}
		return result;
	}
	
	private List<String> getSynoym(String keyword) {
		//TODO 实现同义词查找
	}

}
