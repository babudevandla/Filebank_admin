package com.sm.admin.dao;

import java.util.List;

import com.sm.admin.model.EmailTemplateContent;
import com.sm.admin.model.EmailTemplates;
import com.sm.admin.model.Testimonials;

public interface GenaralMgntDao {

	void saveTestionials(Testimonials testimonials);

	Testimonials editTestimonials(Integer id);

	void updateTestimonials(Testimonials testimonials);

	List<Testimonials> getTestimonials();

	Integer deleteTestimonials(Integer id);

	List<String> getAllPageNames();

	List<EmailTemplates> getAllEmailTemplates();

	List<EmailTemplateContent> getAllEmailTemplateContent();

	void updateGeneralEmailTemplateContent(EmailTemplateContent templateContent);

	EmailTemplateContent getAllSubjectBodyTemplates(Integer emailTemplateId);

}
