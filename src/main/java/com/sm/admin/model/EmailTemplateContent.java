package com.sm.admin.model;

import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Email_TemplateContent")
public class EmailTemplateContent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String templateSubject;
	private String templateBody;
	private Integer templateId;
	
	public EmailTemplateContent() {
	}

	public EmailTemplateContent(Integer id,
			String templateSubject, String templateBody, Integer templateId) {
		super();
		this.id = id;
		this.templateSubject = templateSubject;
		this.templateBody = templateBody;
		this.templateId = templateId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idEmailTemplateContent", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "templateSubject", length = 500)
	public String getTemplateSubject() {
		return this.templateSubject;
	}

	public void setTemplateSubject(String templateSubject) {
		this.templateSubject = templateSubject;
	}

	@Column(name = "templateBody", length = 5000)
	public String getTemplateBody() {
		return this.templateBody;
	}

	public void setTemplateBody(String templateBody) {
		this.templateBody = templateBody;
	}

	@Column(name = "emailTemplateId")
	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	
}
