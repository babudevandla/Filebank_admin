package com.sm.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sm.admin.dao.FAQDao;
import com.sm.admin.model.ManageFAQ;

@Service
@Transactional
public class FAQServiceImpl implements FAQService{

	@Autowired
	public FAQDao faqDao;

	
	@Override
	public void updateFAQDetails(ManageFAQ faq) {
		faqDao.updateFAQDetails(faq);	
	}

	@Override
	public List<ManageFAQ> getFAQList() {
		return faqDao.getFAQAnswerList();
	}

	@Override
	public void saveFAQ(ManageFAQ faq) {
		faqDao.saveFAQ(faq);
	}

	@Override
	public ManageFAQ getFAQById(Integer faqId) {
		return faqDao.getFAQById(faqId);
	}

	@Override
	public void updateFaq(ManageFAQ manageFAQ) {
		faqDao.updateFaq(manageFAQ);
	}

	@Override
	public Integer deleteFaq(Integer faqId) {
		return faqDao.deleteFaq(faqId);
	}

	
	
}
