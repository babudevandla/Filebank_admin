package com.sm.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sm.admin.dao.SmtpDao;
import com.sm.admin.model.SmtpDetails;

@Service
@Transactional
public class SmtpServiceImpl implements SmtpService {

	@Autowired
	SmtpDao smtpDao;
	
	@Override
	public SmtpDetails getSmtpDetails() {
		return smtpDao.getSmtpDetails();
	}

	@Override
	public void updateSmtpDetails(SmtpDetails smtp) {
		smtpDao.updateSmtpDetails(smtp);
	}


}
