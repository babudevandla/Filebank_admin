package com.sm.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sm.admin.dto.BlogsDto;
import com.sm.admin.service.BlogService;

@Controller
@RequestMapping("/admin")
public class AdminBlogController {

   private static final Logger logger = LoggerFactory.getLogger(AdminBlogController.class);
	
	@Autowired
	BlogService blogService;

	@RequestMapping(value="/blogs-list",method=RequestMethod.GET)
	public String blogsList(Model model){
		logger.info("admin blogs list");
		model.addAttribute("blogsActive", true);
		return "admin/blogslist";
	}
	@RequestMapping(value="/create-blog",method=RequestMethod.GET)
	public String createBlog(Model model){
		logger.info("create-blog page");
		model.addAttribute("blogsActive", true);
		return "admin/create-blog";
	}
	
	@RequestMapping(value="/create-blog",method=RequestMethod.POST)
	public ModelAndView processBlog(@ModelAttribute BlogsDto blogs){
		logger.info("save blogs");
		ModelAndView model=new ModelAndView("redirect:/admin/blogs-list");
		blogService.saveBlogDetails(blogs);
		model.addObject("success","Blog Successfully saved!");
		return model;
	}
	
}
