package com.sm.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminPropertyListController {

	private static final Logger logger = LoggerFactory.getLogger(AdminPropertyListController.class);
	
	@RequestMapping(value="/property-listings",method=RequestMethod.GET)
	public String propertyList(Model model){
		logger.info("propertyList page");
		
		model.addAttribute("propertyActive", true);
		
		return "admin/property-listings";
	}
	
	@RequestMapping(value="/add-properties",method=RequestMethod.GET)
	public String addProperty(Model model){
		logger.info("propertyList page");
		
		model.addAttribute("propertyActive", true);
		
		return "admin/add-properties";
	}
}
