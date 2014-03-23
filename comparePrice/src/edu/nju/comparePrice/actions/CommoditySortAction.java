package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.services.CommodityService;

public class CommoditySortAction extends BaseAction {

	private static final long serialVersionUID = -3300385748785696707L;

	private ArrayList<Commodity> commodities = new ArrayList<>();
	private CommodityService commodityService;
	private String selectedMethod = "default";
	
	
	public String execute() {
		String method = request.getParameter("method");
		selectedMethod = method;
		if(method.equals("price")){
			return sortByPrice();
		}else if(method.equals("default")){
			return sortByBrand();
		}else {
			return ERROR;
		}
			
	}

	public String sortByPrice() {
		commodities = commodityService.sortByPrice();
		return SUCCESS;
	}

	public String sortByBrand() {
		commodities = commodityService.sortByBrand();
		return SUCCESS;
	}

	public void setCommodities(ArrayList<Commodity> commodities) {
		this.commodities = commodities;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public ArrayList<Commodity> getCommodities() {
		return commodities;
	}

	public String getSelectedMethod() {
		return selectedMethod;
	}

}
