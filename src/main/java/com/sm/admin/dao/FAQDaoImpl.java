package com.sm.admin.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sm.admin.model.ManageFAQ;

@Repository
public class FAQDaoImpl implements FAQDao{

	@Autowired 
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ManageFAQ> getFAQAnswerList() {
		return sessionFactory.getCurrentSession().createQuery("from ManageFAQ").list();
	}

	@Override
	public void saveFAQ(ManageFAQ faq) {
		sessionFactory.getCurrentSession().save(faq);
	}
	
	@Override
	public void updateFAQDetails(ManageFAQ faq) {
		sessionFactory.getCurrentSession().update(faq);
	}

	@Override
	public ManageFAQ getFAQById(Integer faqId) {
		return (ManageFAQ) sessionFactory.getCurrentSession().createQuery("from ManageFAQ where faqId=:faqId").setParameter("faqId", faqId).uniqueResult();
	}

	@Override
	public void updateFaq(ManageFAQ manageFAQ) {
		sessionFactory.getCurrentSession().createQuery("update ManageFAQ set question=:question,answer=:answer where faqId=:faqId")
		.setParameter("question", manageFAQ.getQuestion())
		.setParameter("answer", manageFAQ.getAnswer())
		.setParameter("faqId", manageFAQ.getFaqId()).executeUpdate();
	}

	@Override
	public Integer deleteFaq(Integer faqId) {
		return sessionFactory.getCurrentSession().createQuery("delete from ManageFAQ where faqId=:faqId").setParameter("faqId", faqId).executeUpdate();
	}

	

	
}
