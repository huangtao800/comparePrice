package edu.nju.comparePrice.services;

import java.util.*;

import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.Commodity;

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
		Brand b1 = new Brand();
		b1.setWeight(10);
		Brand b2 = new Brand();
		b2.setWeight(20);
		Commodity c1 = new Commodity();
		Commodity c2 = new Commodity();
		c1.setName("aaaa");
		c2.setName("bbbb");
		c1.setBrand(b1);
		c2.setBrand(b2);
		c1.setPrice(20.0);
		c2.setPrice(10.0);
		result.add(c1);
		result.add(c2);
		// 做测试
		commodityList = result;
		return result;
	}

}
