package com.sm.admin.startup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EbCategories implements Serializable {

	private Integer categoryId;
	private int parentCatId;
	private String categoryName;
	private Boolean isactive;
	private String slugName;
	private Set<EbCategoryGrouping> ebCategoryGroupings = new HashSet<EbCategoryGrouping>(
			0);
	private List<Integer> subCategories;
	private Boolean popular;
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public int getParentCatId() {
		return parentCatId;
	}
	public void setParentCatId(int parentCatId) {
		this.parentCatId = parentCatId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	public String getSlugName() {
		return slugName;
	}
	public void setSlugName(String slugName) {
		this.slugName = slugName;
	}
	public Set<EbCategoryGrouping> getEbCategoryGroupings() {
		return ebCategoryGroupings;
	}
	public void setEbCategoryGroupings(Set<EbCategoryGrouping> ebCategoryGroupings) {
		this.ebCategoryGroupings = ebCategoryGroupings;
	}
	public List<Integer> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<Integer> subCategories) {
		this.subCategories = subCategories;
	}
	public Boolean getPopular() {
		return popular;
	}
	public void setPopular(Boolean popular) {
		this.popular = popular;
	}
	public void addSubCategories(Integer subCatId) {
		if(this.subCategories ==null)
			this.subCategories = new ArrayList<Integer>();		
		this.subCategories.add(subCatId);		
	}
}
