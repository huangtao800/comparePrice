package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.services.CommodityService;

public class CommoditySearchAction  extends BaseAction {

	private static final long serialVersionUID = -330085696707L;
	
	private String search;
	private ArrayList<Commodity> commodities = new ArrayList<>();
	private CommodityService commodityService;
	
	public String execute() {
		commodityService.search(search);
		commodities = commodityService.sortByBrand();
		return SUCCESS;
	}
	
	

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}



	public ArrayList<Commodity> getCommodities() {
		return commodities;
	}



	public void setCommodities(ArrayList<Commodity> commodities) {
		this.commodities = commodities;
	}

}
