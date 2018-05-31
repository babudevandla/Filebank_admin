package com.sm.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sm.admin.dto.AgentsDto;
import com.sm.admin.model.Agents;
import com.sm.admin.service.AgentService;

@Controller
@RequestMapping("/admin")
public class AdminAgentController {

	private static final Logger logger = LoggerFactory.getLogger(AdminAgentController.class);
	
	@Autowired
	AgentService agentService;

	@RequestMapping(value="/agents-list",method=RequestMethod.GET)
	public String agentsList(Model model){
		logger.info("adminlogin page");
		List<Agents> agents=agentService.getAgentsList();
		model.addAttribute("agentsalllist", agents);
		model.addAttribute("agentlistActive", true);
		
		return "admin/agentslist";
	}
	
	
	@RequestMapping(value="/create-agent",method=RequestMethod.GET)
	public String createAgent(Model model){
		logger.info("create-agent page");
		
		model.addAttribute("agentlistActive", true);
		
		return "admin/create-agent";
	}
	
	@RequestMapping(value="/create-agent",method=RequestMethod.POST)
	public ModelAndView processAreateAgent(@ModelAttribute AgentsDto agentsDto){
		logger.info("save agent");
		ModelAndView model=new ModelAndView("redirect:/admin/agents-list");
		agentService.saveAgentDetails(agentsDto);
		model.addObject("success","Agent Successfully saved!");
		return model;
	}
}
