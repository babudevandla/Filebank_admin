package com.sm.admin.dto;

import org.springframework.web.multipart.MultipartFile;

public class AgentsDto {

	private Integer agentId;
	private String agent_name;
	private String agent_email;
	private String mobile_no;
	private String office_no;
	private String description;
	private String agent_modifiedImg;
	private boolean status;
	
	private MultipartFile file;
	
	public Integer getAgentId() {
		return agentId;
	}
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	public String getAgent_name() {
		return agent_name;
	}
	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}
	public String getAgent_email() {
		return agent_email;
	}
	public void setAgent_email(String agent_email) {
		this.agent_email = agent_email;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getOffice_no() {
		return office_no;
	}
	public void setOffice_no(String office_no) {
		this.office_no = office_no;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAgent_modifiedImg() {
		return agent_modifiedImg;
	}
	public void setAgent_modifiedImg(String agent_modifiedImg) {
		this.agent_modifiedImg = agent_modifiedImg;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
