package com.sm.admin.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.sm.admin.constants.CONSTANTS;
import com.sm.admin.startup.EbCategories;



@Service("inMemoryCache")
public class InMemoryCache {	
	
	public static String contextPath = "";
	
	
	// need to check 
	public static Map<Integer,EbCategories> CATEGORY_CACHE = new LinkedHashMap<Integer,EbCategories>();
	
	public static Map<Integer, Integer[]> CATEGORY_MAP = new HashMap<Integer,Integer[]>();
	private static HashMap<Integer, Integer> vatMap =  null;
	public static HashMap<String,String> propertyMap = null;
	private static HashMap<String ,String> COUNTRY_MAP_1 =  new LinkedHashMap<String,String>();
	private static HashMap<String ,String> COUNTRY_MAP_2 =  new LinkedHashMap<String,String>();
	public static String salt ="WFNQlLCH";
	public static int[] preferredFormats = new int[1];
	public static String totalBookCount = null;
	public static String eBookCount = null;
	public static String audioBookCount = null;

	
	//Temporary arrangement till the hibernate mapping is solved ...


	//public static HashMap<Integer,List<Integer>> QIOZK_CATEGORYMAP = new HashMap<Integer, List<Integer>>();
	public static boolean isProductionEnv = false;
	//public static boolean forceRunJobs = false;
	
	static{
		String environment = System.getProperty("ENV");
		System.out.println(" environment varaiable from the startup "+environment);
		if(StringUtils.equalsIgnoreCase(environment, "production")){
			isProductionEnv = true;
		}else{
			isProductionEnv = false;
			//forceRunJobs = true;
		}
		
		System.out.println(" final environment varaiable from the startup "+ (isProductionEnv?"PRODUCTION":"TEST"));
		
	}
	public InMemoryCache() {
	}
	public static HashMap<String, String> getCOUNTRY_MAP_1() {
		return COUNTRY_MAP_1;
	}
	public static void setCOUNTRY_MAP_1(HashMap<String, String> cOUNTRY_MAP_1) {
		COUNTRY_MAP_1 = cOUNTRY_MAP_1;
	}
	public static HashMap<String, String> getCOUNTRY_MAP_2() {
		return COUNTRY_MAP_2;
	}
	public static void setCOUNTRY_MAP_2(HashMap<String, String> cOUNTRY_MAP_2) {
		COUNTRY_MAP_2 = cOUNTRY_MAP_2;
	}
	
	/* need to check */
	public static Map<Integer,EbCategories> getCATEGORY_CACHE() {
		return CATEGORY_CACHE;
	}
	
	public static int getVat(Integer vatForProductType){
		Integer vatPercentage = (Integer)vatMap.get(vatForProductType);
		if(vatPercentage == null)
			vatPercentage = (Integer)vatMap.get(CONSTANTS.VAT_PROD_OTHER);
		return vatPercentage!=null?vatPercentage:0;
	}
	public static void setVatMap(HashMap<Integer, Integer> vat){
		vatMap = vat;		
	}
	public static HashMap<Integer, Integer> getVatMap(){
		return vatMap;
	}
	public static HashMap<String, String> getPropertyMap(){
		return propertyMap;
	}
	public static void setPropertyMap(HashMap<String, String> properties){
		propertyMap = properties;
	}
	
	public static  String getEbProperty(String key){
		return propertyMap.get(key)==null?"":propertyMap.get(key);
	}
	public static  void setEbProperty(String key,String value){
		propertyMap.put(key,value);
	}
	public static  void setVat(Integer key,Integer value){
		vatMap.put(key,value);
	}

	
	
	
}
