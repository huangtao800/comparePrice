package edu.nju.comparePrice.actions;

import edu.nju.comparePrice.services.CrawlerService;


public class CrawlerAction  extends BaseAction{
	private CrawlerService crawlerService;
	
	public String updateCommodity(){
		crawlerService.updateCommodity();
		return "success";
	}
	public void setCrawlerService(CrawlerService crawlerService){
		this.crawlerService = crawlerService;
	}
	public CrawlerService getCrawlerService(){
		return crawlerService;
	}

}
