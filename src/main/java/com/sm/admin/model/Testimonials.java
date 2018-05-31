package com.sm.admin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="testimonials")
public class Testimonials {
	
	private Integer id;
	private String clientName;
	private String location;
	private Date date;
	private String content;
	private byte[] clientImage;
	private boolean image;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	@Column(name="client_name")
	public String getClientName() {
		return clientName;
	}
	@Column(name="place")
	public String getLocation() {
		return location;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	public Date getDate() {
		return date;
	}
	@Column(name="content")
	public String getContent() {
		return content;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private String testdate;
	@Transient
	public String getTestdate() {
		return testdate;
	}
	public void setTestdate(String testdate) {
		this.testdate = testdate;
	}
	@Column(name="client_image")
	public byte[] getClientImage() {
		return clientImage;
	}
	public void setClientImage(byte[] clientImage) {
		this.clientImage = clientImage;
	}
	
	@Column(name="image")
	public boolean isImage() {
		return image;
	}
	public void setImage(boolean image) {
		this.image = image;
	}
	
}
