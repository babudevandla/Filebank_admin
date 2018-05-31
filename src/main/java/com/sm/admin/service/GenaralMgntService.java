package com.sm.admin.service;

import java.util.List;

import com.sm.admin.model.EmailTemplateContent;
import com.sm.admin.model.EmailTemplates;
import com.sm.admin.model.Testimonials;

public interface GenaralMgntService {


	Integer deleteTestimonials(Integer id);

	Testimonials editTestimonials(Integer id);

	List<Testimonials> getTestimonials();

	void saveTestionials(Testimonials testimonials);

	void updateTestimonials(Testimonials testimonials);

	List<String> getAllPageNames();

	List<EmailTemplates> getAllEmailTemplates();

	List<EmailTemplateContent> getAllEmailTemplateContent();

	void updateGeneralEmailTemplateContent(EmailTemplateContent templateContent);

	EmailTemplateContent getAllSubjectBodyTemplates(Integer emailTemplateId);

	
}
