package com.sm.admin.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sm.admin.model.SmtpDetails;

@Repository
public class SmtpDaoImpl implements SmtpDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public SmtpDetails getSmtpDetails() {
		SmtpDetails smtpDetails=(SmtpDetails) sessionFactory.getCurrentSession().createQuery("from SmtpDetails").uniqueResult();
		return smtpDetails;
	}

	@Override
	public void updateSmtpDetails(SmtpDetails smtp) {
		sessionFactory.getCurrentSession().saveOrUpdate(smtp);
	}



}
