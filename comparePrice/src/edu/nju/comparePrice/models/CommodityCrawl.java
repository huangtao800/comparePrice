package edu.nju.comparePrice.models;

import java.util.HashSet;
import java.util.Set;

public class CommodityCrawl {
	private String name; 
	private double price; 
	private int unit; 
	private int brandId;
	private String brandName; 
	private String link; 
	private String onlineId;
	
	public CommodityCrawl(String name, double price, int unit, String brandName, String link, String onlineId){
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.brandName = brandName;
		this.brandId = -1;
		this.link = link;
		this.onlineId = onlineId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getOnlineId() {
		return onlineId;
	}
	public void setOnlineId(String onlineId) {
		this.onlineId = onlineId;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}  


}
