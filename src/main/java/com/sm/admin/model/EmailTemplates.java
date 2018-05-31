package com.sm.admin.model;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Email_Templates")
public class EmailTemplates implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer emailTemplateId;
	private String templateName;

	public EmailTemplates() {
	}

	public EmailTemplates(Integer emailTemplateId, String templateName) {
		super();
		this.emailTemplateId = emailTemplateId;
		this.templateName = templateName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "emailTemplateId", unique = true, nullable = false)
	public Integer getEmailTemplateId() {
		return emailTemplateId;
	}

	public void setEmailTemplateId(Integer emailTemplateId) {
		this.emailTemplateId = emailTemplateId;
	}

	@Column(name = "templateName")
	public String getTemplateName() {
		return this.templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

}
