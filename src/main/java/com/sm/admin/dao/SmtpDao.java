package com.sm.admin.dao;

import com.sm.admin.model.SmtpDetails;


public interface SmtpDao {

	public SmtpDetails getSmtpDetails();

	public void updateSmtpDetails(SmtpDetails smtp);

}
