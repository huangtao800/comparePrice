package edu.nju.comparePrice.services.search.lexicon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.comparePrice.dao.DaoFacade;
import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.models.Synonym;

public class LexiconSearcher {
	
	@Autowired
	private DaoFacade dao;
	
	/**
	 * 从数据库中查找指定关键词列表所对应商品
	 * @param keywords 关键词列表
	 * @return 商品列表
	 */
	public ArrayList<Commodity> lookup(List<Synonym> keywords) {
		return dao.findCommodity(keywords);
	}
}
