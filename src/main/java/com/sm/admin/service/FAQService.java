package com.sm.admin.service;

import java.util.List;

import com.sm.admin.model.ManageFAQ;

public interface FAQService {

	List<ManageFAQ> getFAQList();

	void updateFAQDetails(ManageFAQ faq);

	void saveFAQ(ManageFAQ faq);

	ManageFAQ getFAQById(Integer faqId);

	void updateFaq(ManageFAQ manageFAQ);

	Integer deleteFaq(Integer faqId);

	

}
