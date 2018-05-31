package com.sm.admin.dao;

import java.util.List;

import com.sm.admin.model.ManageFAQ;


public interface FAQDao {

	void updateFAQDetails(ManageFAQ faq);

	List<ManageFAQ> getFAQAnswerList();

	void saveFAQ(ManageFAQ faq);

	ManageFAQ getFAQById(Integer faqId);

	void updateFaq(ManageFAQ manageFAQ);

	Integer deleteFaq(Integer faqId);

	

}
