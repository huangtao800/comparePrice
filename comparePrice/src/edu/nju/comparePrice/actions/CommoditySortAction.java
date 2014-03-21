package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.services.CommodityService;

public class CommoditySortAction extends BaseAction {

	private static final long serialVersionUID = -3300385748785696707L;

	private ArrayList<Commodity> commodities = new ArrayList<>();
	private CommodityService commodityService;

	public String sortByPrice() {
		commodities = commodityService.sortByPrice(commodities);
		return SUCCESS;
	}

	public String sortByBrand() {
		commodities = commodityService.sortByBrand(commodities);
		return SUCCESS;
	}

}
