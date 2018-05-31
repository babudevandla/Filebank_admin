package com.sm.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sm.admin.common.MESSAGECONSTANT;
import com.sm.admin.model.SmtpDetails;
import com.sm.admin.service.SmtpService;

@Controller
@RequestMapping("/admin")
public class AdminSMTPController  {

	private static final Logger logger = LoggerFactory.getLogger(AdminSMTPController.class);
	
	@Autowired
	public SmtpService smtpService;	
	
	/**
	 * @message This is responsible for Saving the STMP details
	 * @param get the smtp details from properties file
	 * @param using file inputstream and properties 
	 * @throws NullPointer Exception
	 * @return set the smtp details to model object and call appropriate view Page	 * 
	 */
	
    @RequestMapping(value="/smtp-details")
    public String showSmtpDetails(Model model) {
    	logger.debug("Inside Smtp Information"); 
		SmtpDetails smtpDetails=smtpService.getSmtpDetails();
		model.addAttribute("smtpDetails",smtpDetails);
		model.addAttribute("smtpActive", true);
		
        return "admin/smtp-details";
    }
    
    @RequestMapping(value="/updateSmtp")
	public String adminSmtp(@ModelAttribute SmtpDetails smtp,Model model,final RedirectAttributes redirectAttributes){
    	logger.info("admin SMTP");
		smtpService.updateSmtpDetails(smtp);
		redirectAttributes.addFlashAttribute("message",MESSAGECONSTANT.SMTP_SUCCESS);
		model.addAttribute("smtpdetails",smtp);
		
		return "redirect:/admin/smtp-details";	
	}
    
    
   
    
}
