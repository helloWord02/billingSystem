package com.test_project.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 服务器信息实体Bean
 * 
 * @author huangjun
 * @version 1.0
 * @created 25-11��-2017 15:09:23
 */
@Entity
@Table(name="t_service")
public class ServiceBean {
	
	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")
	private long id;
	private String ip;
	@Column(name="loginout_time")
	private Date loginoutTime;
	@Column(name="login_time")
	private Date loginTime;
	@Column(name="busniess_account")
	private String busniessAccount;

	public ServiceBean() {

	}

	
	public ServiceBean(String ip, Date loginoutTime, Date loginTime, String busniessAccount) {
		super();
		this.ip = ip;
		this.loginoutTime = loginoutTime;
		this.loginTime = loginTime;
		this.busniessAccount = busniessAccount;
	}


	public String getBusniessAccount() {
		return busniessAccount;
	}

	public void setBusniessAccount(String busniessAccount) {
		this.busniessAccount = busniessAccount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginoutTime() {
		return loginoutTime;
	}

	public void setLoginoutTime(Date loginoutTime) {
		this.loginoutTime = loginoutTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@Override
	public String toString() {
		return "ServiceBean [id=" + id + ", ip=" + ip + ", loginoutTime=" + loginoutTime + ", loginTime=" + loginTime
				+ ", busniessAccount=" + busniessAccount + "]";
	}




}