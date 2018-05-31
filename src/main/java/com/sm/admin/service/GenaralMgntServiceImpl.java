package com.sm.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sm.admin.dao.GenaralMgntDao;
import com.sm.admin.model.EmailTemplateContent;
import com.sm.admin.model.EmailTemplates;
import com.sm.admin.model.Testimonials;

@Service
@Transactional
public class GenaralMgntServiceImpl implements GenaralMgntService {

	@Autowired
	private GenaralMgntDao genaralMgntDao;
	@Autowired 
	private UploadFilesPathService uploadFilesPathService;
	/*
	 *  Testmonial methods
	 */
	
	@Override
	public void saveTestionials(Testimonials testimonials) {
		genaralMgntDao.saveTestionials(testimonials);
	}

	@Override
	public List<Testimonials> getTestimonials() {
		return genaralMgntDao.getTestimonials();
	}

	@Override
	public Testimonials editTestimonials(Integer id) {
		return genaralMgntDao.editTestimonials(id);
	}

	@Override
	public void updateTestimonials(Testimonials testimonials) {
		genaralMgntDao.updateTestimonials(testimonials);
	}

	@Override
	public Integer deleteTestimonials(Integer id) {
		return genaralMgntDao.deleteTestimonials(id);		
	}

	@Override
	public List<String> getAllPageNames() {
		return genaralMgntDao.getAllPageNames();
	}

	@Override
	public List<EmailTemplates> getAllEmailTemplates() {
		return genaralMgntDao.getAllEmailTemplates();
	}

	@Override
	public List<EmailTemplateContent> getAllEmailTemplateContent() {
		return genaralMgntDao.getAllEmailTemplateContent();
	}

	@Override
	public void updateGeneralEmailTemplateContent(EmailTemplateContent templateContent) {
		genaralMgntDao.updateGeneralEmailTemplateContent(templateContent);		
	}

	@Override
	public EmailTemplateContent getAllSubjectBodyTemplates(Integer emailTemplateId) {
		return genaralMgntDao.getAllSubjectBodyTemplates(emailTemplateId);
	}

		
}
