package com.sm.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminLoginController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(Model model){
		logger.info("adminlogin page");
		
		model.addAttribute("adminLoginActive", true);
		
		return "admin/adminLogin";
	}
}
