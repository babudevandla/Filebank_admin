package com.sm.admin.startup;

import java.io.Serializable;


public class EbCategoryGrouping implements Serializable {

	private Integer id;
	private EbCategories ebCategories;
	private int elibCategory;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public EbCategories getEbCategories() {
		return ebCategories;
	}
	public void setEbCategories(EbCategories ebCategories) {
		this.ebCategories = ebCategories;
	}
	public int getElibCategory() {
		return elibCategory;
	}
	public void setElibCategory(int elibCategory) {
		this.elibCategory = elibCategory;
	}
}
