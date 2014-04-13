package edu.nju.comparePrice.services.search.preprocess.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.comparePrice.dao.DaoFacade;
import edu.nju.comparePrice.models.Synonym;
import edu.nju.comparePrice.services.search.preprocess.Expander;

public class SimpleExpander implements Expander<Synonym> {
	
	private DaoFacade daoFacade = DaoFacade.getInstance();

	@Override
	public List<Synonym> expander(List<String> keywords) {
		List<Synonym> result = new ArrayList<Synonym>();
		for(String keyword : keywords) {
			Synonym syn = getSynonym(keyword);
			result.add(syn);
		}
		return result;
	}
	
	private Synonym getSynonym(String keyword) {
		System.out.println(daoFacade.getCurrentMaxFlag());
		Synonym syn = daoFacade.getSynonymByName(keyword);
		System.out.println(syn == null);
		if (!keyword.equals(syn.getName()))
			syn.setName(keyword);
		return syn;
	}
}
