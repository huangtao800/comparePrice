package edu.nju.comparePrice.services;

import java.util.*;

import edu.nju.comparePrice.models.Commodity;

public class CommodityService {
	public ArrayList<Commodity> sortByPrice(ArrayList<Commodity> commodityList) {
		Collections.sort(commodityList, new Comparator<Commodity>() {
			public int compare(Commodity c1, Commodity c2) {
				return (int) (c1.getPrice() - c2.getPrice());
			}
		});
		return commodityList;
	}

	public ArrayList<Commodity> sortByBrand(ArrayList<Commodity> commodityList) {

		Collections.sort(commodityList, new Comparator<Commodity>() {
			public int compare(Commodity c1, Commodity c2) {
				return (c1.getWeight() - c2.getWeight());
			}
		});

		return commodityList;
	}

}
