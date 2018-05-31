package com.sm.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "captcha")
public class Captcha implements Serializable {

	private Integer captchaId;
	private Integer firstnumber;
	private Integer secondnumber;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="captcha_id")
	public Integer getCaptchaId() {
		return captchaId;
	}

	public void setCaptchaId(Integer captchaId) {
		this.captchaId = captchaId;
	}

	@Column(name="firstnumber")
	public Integer getFirstnumber() {
		return firstnumber;
	}

	public void setFirstnumber(Integer firstnumber) {
		this.firstnumber = firstnumber;
	}

	@Column(name="secondnumber")
	public Integer getSecondnumber() {
		return secondnumber;
	}

	public void setSecondnumber(Integer secondnumber) {
		this.secondnumber = secondnumber;
	}

}
