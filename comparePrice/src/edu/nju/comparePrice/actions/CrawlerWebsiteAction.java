package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.CrawlerWebsite;
import edu.nju.comparePrice.services.SystemAdminService;

public class CrawlerWebsiteAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6999793750127865521L;
	private SystemAdminService systemAdminService;
	private String websiteName;
	private String websiteLink;
	private ArrayList<CrawlerWebsite> crawlerWebsiteList=new ArrayList<CrawlerWebsite>();
	
	public String execute(){
		websiteName="";
		websiteLink="";
		crawlerWebsiteList=systemAdminService.getCrawlerWebsiteList();
		return "Success";
	}
	
	public String add(){
		boolean result=systemAdminService.addCrawlerWebsite(websiteName, websiteLink);
		if(result)
			return "Success";
		else {
			return "input";
		}
	}
	
	public String remove(){
		int crawlerWebsiteId=Integer.parseInt(request.getParameter("crawlerWebsiteId"));
		boolean result=systemAdminService.deleteCrawlerWebsite(crawlerWebsiteId);
		if(result)
			return "Success";
		else {
			return "input";
		}
	}

	public SystemAdminService getSystemAdminService() {
		return systemAdminService;
	}

	public void setSystemAdminService(SystemAdminService systemAdminService) {
		this.systemAdminService = systemAdminService;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public ArrayList<CrawlerWebsite> getCrawlerWebsiteList() {
		return crawlerWebsiteList;
	}

	public void setCrawlerWebsiteList(ArrayList<CrawlerWebsite> crawlerWebsiteList) {
		this.crawlerWebsiteList = crawlerWebsiteList;
	}
	
	

}
