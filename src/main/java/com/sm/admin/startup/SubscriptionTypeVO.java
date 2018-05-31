package com.sm.admin.startup;

public class SubscriptionTypeVO {
	
	private int subId;
	private String subName;
	private float price;
	private float subPrice;
	
	
	
	public SubscriptionTypeVO(int subId, String subName, float price, float subPrice) {
		super();
		this.subId = subId;
		this.subName = subName;
		this.price = price;
		this.subPrice = subPrice;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getSubPrice() {
		return subPrice;
	}
	public void setSubPrice(float subPrice) {
		this.subPrice = subPrice;
	}
	
	
	
}
