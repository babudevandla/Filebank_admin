package com.sm.admin.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sm.admin.dto.UsersDto;
import com.sm.admin.model.Users;
import com.sm.admin.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserManagementController {

	private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user_list",method=RequestMethod.GET)
	public ModelAndView usersList(Model model,Principal principal){
		logger.info("usersList page");
		ModelAndView mvc=new ModelAndView("users/usersList");
		List<UsersDto> userslist=userService.getCustomersList(principal);
		mvc.addObject("userslist", userslist);
		mvc.addObject("usersStatus", true);
		
		return mvc;
	}
}
