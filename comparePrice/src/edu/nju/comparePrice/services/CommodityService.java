package edu.nju.comparePrice.services;

import java.util.*;

import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.services.search.SearchController;

public class CommodityService {
	private ArrayList<Commodity> commodityList = new ArrayList<>();

	public ArrayList<Commodity> sortByPrice() {
		Collections.sort(commodityList, new Comparator<Commodity>() {
			public int compare(Commodity c1, Commodity c2) {
				return (int) (c1.getPrice() - c2.getPrice());
			}
		});
		return commodityList;
	}

	public ArrayList<Commodity> sortByBrand() {

		Collections.sort(commodityList, new Comparator<Commodity>() {
			public int compare(Commodity c1, Commodity c2) {
				return (c1.getBrand().getWeight() - c2.getBrand().getWeight());
			}
		});

		return commodityList;
	}

	public ArrayList<Commodity> search(String keyword) {
		ArrayList<Commodity> result = new ArrayList<>();
		SearchController searchController =new SearchController();
		result=searchController.search(keyword);
		// 做测试
		commodityList = result;
		return result;
	}

}
