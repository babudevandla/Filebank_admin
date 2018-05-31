package com.sm.admin.model;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "smtp_details")
public class SmtpDetails implements java.io.Serializable {

	private Integer smptId;
	private String hostname;
	private String password;
	private Integer portno;
	private String username;

	public SmtpDetails() {
	}

	public SmtpDetails(String hostname, String password, Integer portno,
			String username) {
		this.hostname = hostname;
		this.password = password;
		this.portno = portno;
		this.username = username;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "smptId", unique = true, nullable = false)
	public Integer getSmptId() {
		return this.smptId;
	}

	public void setSmptId(Integer smptId) {
		this.smptId = smptId;
	}

	@Column(name = "hostname")
	public String getHostname() {
		return this.hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "portno")
	public Integer getPortno() {
		return this.portno;
	}

	public void setPortno(Integer portno) {
		this.portno = portno;
	}

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
