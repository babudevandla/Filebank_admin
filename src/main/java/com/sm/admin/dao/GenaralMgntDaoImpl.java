package com.sm.admin.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sm.admin.model.EmailTemplateContent;
import com.sm.admin.model.EmailTemplates;
import com.sm.admin.model.Testimonials;

@Repository
public class GenaralMgntDaoImpl implements GenaralMgntDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveTestionials(Testimonials testimonials) {
		sessionFactory.getCurrentSession().save(testimonials);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Testimonials> getTestimonials() {
		return sessionFactory.getCurrentSession().createQuery("from Testimonials").list();
	}

	@Override
	public Testimonials editTestimonials(Integer id) {
		return (Testimonials) sessionFactory.getCurrentSession().createQuery("from Testimonials where id=:id")
				.setParameter("id", id).uniqueResult();
	}

	@Override
	public void updateTestimonials(Testimonials testimonials) {
		sessionFactory.getCurrentSession().createQuery("update Testimonials set clientName=:clientName,location=:location,content=:content,clientImage=:clientImage where id=:id")
		.setParameter("clientName", testimonials.getClientName())
		.setParameter("location", testimonials.getLocation())
		.setParameter("content", testimonials.getContent())
		.setParameter("clientImage", testimonials.getClientImage())
		.setParameter("id", testimonials.getId()).executeUpdate();
	}

	@Override
	public Integer deleteTestimonials(Integer id) {
		Integer result =sessionFactory.getCurrentSession().createQuery("delete from Testimonials where id=:id").setParameter("id", id).executeUpdate();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllPageNames() {
		Query query = sessionFactory.getCurrentSession().createQuery("select c.masterMenuName from ContentManager c");
		return query.list();
	}

	
	public EmailTemplateContent getAllSubjectBodyTemplates(Integer emailTemplateId) {
		Criteria criteria =  sessionFactory.getCurrentSession().createCriteria(EmailTemplateContent.class);
		criteria.add(Restrictions.eq("templateId", emailTemplateId));
		
		EmailTemplateContent emailTemplatesContent = (EmailTemplateContent)criteria.uniqueResult();
		
		return emailTemplatesContent;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmailTemplates> getAllEmailTemplates() {
		
		return sessionFactory.getCurrentSession().createQuery("from EmailTemplates").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmailTemplateContent> getAllEmailTemplateContent() {
		
		return sessionFactory.getCurrentSession().createQuery("from EmailTemplateContent").list();
	}

	@Override
	public void updateGeneralEmailTemplateContent(EmailTemplateContent templateContent) {
		
		if(templateContent.getId()!=null){
			
			sessionFactory.getCurrentSession().saveOrUpdate(templateContent);
		}
	}

}
