package com.sm.admin.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sm.admin.model.Users;
import com.sm.admin.service.UserService;

@Controller
@RequestMapping("/admin")
public class ProfileController {

	
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public String viewProfile(Model model,Principal principal){
		logger.info("viewProfile page");
		Users user=userService.findUserByUserName(principal.getName());
		model.addAttribute("user", user);
		return "profile/profile_view";
	}
	
}
