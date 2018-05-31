package com.sm.admin.service;

import com.sm.admin.model.SmtpDetails;


public interface SmtpService {

	public SmtpDetails getSmtpDetails();

	public void updateSmtpDetails(SmtpDetails smtp);

	
}
