package com.test_project.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 服务器信息实体Bean
 * 
 * @author huangjun
 * @version 1.0
 * @created 25-11��-2017 15:09:23
 */

public class ServiceBean {

	private String busniessAccount;
	private long id;
	private int ip;
	private Date loginoutTime;
	private Date loginTime;
	private long timeLong;

	public ServiceBean() {

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

	public int getIp() {
		return ip;
	}

	public void setIp(int ip) {
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

	public long getTimeLong() {
		return timeLong;
	}

	public void setTimeLong(long timeLong) {
		this.timeLong = timeLong;
	}

	@Override
	public String toString() {
		return "ServiceBean [busniessAccount=" + busniessAccount + ", id=" + id + ", ip=" + ip + ", loginoutTime="
				+ loginoutTime + ", loginTime=" + loginTime + ", timeLong=" + timeLong + "]";
	}

}