package com.sm.admin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "faq_management")
public class ManageFAQ implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer faqId;
	private String question;
	private String answer;
	private Date createdDate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="faqId")
	public Integer getFaqId() {
		return faqId;
	}
	public void setFaqId(Integer faqId) {
		this.faqId = faqId;
	}
	
	@Column(name="question")
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Column(name="answer")
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Column(name="createdDate")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
