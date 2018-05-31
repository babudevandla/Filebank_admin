package com.sm.admin.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agents_details")
public class Agents implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer agentId;
	private String agentName;
	private String agentEmail;
	private String mobileNo;
	private String officeNo;
	private String description;
	private String agentModifiedImg;
	private String agentOriginalImg;
	private boolean status;
	
	public Agents(){
		
	}
	public Agents(Integer agentId) {
		super();
		this.agentId = agentId;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "agent_id", unique = true, nullable = false)
	public Integer getAgentId() {
		return agentId;
	}
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	@Column(name = "name")
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	@Column(name = "email")
	public String getAgentEmail() {
		return agentEmail;
	}
	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}
	@Column(name = "mobileno")
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@Column(name = "officeno")
	public String getOfficeNo() {
		return officeNo;
	}
	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "modified_img")
	public String getAgentModifiedImg() {
		return agentModifiedImg;
	}
	public void setAgentModifiedImg(String agentModifiedImg) {
		this.agentModifiedImg = agentModifiedImg;
	}
	
	@Column(name="originalImg")
	public String getAgentOriginalImg() {
		return agentOriginalImg;
	}
	public void setAgentOriginalImg(String agentOriginalImg) {
		this.agentOriginalImg = agentOriginalImg;
	}
	@Column(name="status")
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
