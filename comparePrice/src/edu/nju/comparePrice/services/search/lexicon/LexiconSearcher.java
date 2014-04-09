package edu.nju.comparePrice.services.search.lexicon;

import java.util.ArrayList;
import java.util.List;

import edu.nju.comparePrice.models.Commodity;

public class LexiconSearcher {
	
	/**
	 * 从数据库中查找指定关键词列表所对应商品
	 * @param keywords 关键词列表
	 * @return 商品列表
	 */
	public ArrayList<Commodity> lookup(List<List<String>> keywords) {
		//TODO 调用数据库接口实现
		return new ArrayList<Commodity>();
		
	}
}
