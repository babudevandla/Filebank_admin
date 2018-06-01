package com.sm.admin.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sm.admin.common.CommonController;
import com.sm.admin.model.Users;
import com.sm.admin.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController extends CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String home(Model model){
		logger.info("adminlogin page");
		
		model.addAttribute("adminLoginActive", true);
		
		return "admin/adminLogin";
	}
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model, HttpSession httpSession) {

		model.addAttribute("error", "true");

		return "admin/adminLogin";
	}
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model, HttpSession httpSession,final RedirectAttributes redirectAttributes ) {
		
		redirectAttributes.addFlashAttribute("accessDeined", true);
		
		return "redirect:/admin/login";
	}
	
	@RequestMapping(value="/forgot-password",method=RequestMethod.GET)
	public String forgotPassword(Model model){
		logger.info("forgotPassword page");
		model.addAttribute("forgetPwdActive", true);
		
		return "admin/forgotpassword";
	}
	
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String adminDashboard(Model model,Principal principal){
		logger.info("adminDashboard page");
		/*Long usersCount=userService.getRegistedUsersCount();*/
		
		Users user=userService.findUserByUserName(principal.getName());
		model.addAttribute("user", user);
		model.addAttribute("dashActive", true);
		return "admin/adminDashboard";
	}
	
	/*@RequestMapping(value="/send-forgotpwd", method=RequestMethod.GET)
	public String emailUserDetails(@ModelAttribute UsersDto usersDto,Model model,  HttpServletRequest request,final RedirectAttributes attributes){
		
		 logger.info("Sending username password to user..");
		 SmtpDetails smtp=smtpService.getSmtpDetails();
		 EmailTemplateContent emailTemplatesContent = genaralMgntService.getAllSubjectBodyTemplates(4);
		 Users userInfo = userService.findUserByUserName(usersDto.getEmail());
		if(userInfo!=null) {
			Email email1=new Email();
			email1.setMailto(usersDto.getEmail());
			EmailSender.host = request.getScheme() + "://"	+ request.getHeader("host") + request.getContextPath();
			emailSender.forgotPassword(userInfo,email1, velocityEngine,request, emailTemplatesContent, smtp);
			System.out.println("Email sent successfully");
			attributes.addFlashAttribute("message", FORGOT_SUCCESS_MSG);
			return "redirect:/admin/login";
		} else {
			attributes.addFlashAttribute("message", FORGOT_FAILURE_MSG);
			return "redirect:/admin/forgot-password";
		}
	}*/
}