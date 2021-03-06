package com.test_project.bean;

import java.util.Date;

/**
 * 记录服务器某年使用总时长实体bean
 * @author xl
 *
 */
public class AccountYearBean {


	private long id;
	/**
	 * 业务账号
	 */
	private String account;
	
	/**
	 * 某年总时长
	 */
	private long allTime;
	/**
	 * 查询时间（具体某年）
	 * 
	 */
	private Date dateYear;
	/**
	 * 服务器ip
	 */
	private String ip;
	
	public AccountYearBean() {
		super();
	}

	public AccountYearBean(String account, long allTime, Date dateYear, String ip) {
		super();
		this.account = account;
		this.allTime = allTime;
		this.dateYear = dateYear;
		this.ip = ip;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public long getAllTime() {
		return allTime;
	}

	public void setAllTime(long allTime) {
		this.allTime = allTime;
	}

	public Date getDateYear() {
		return dateYear;
	}

	public void setDateYear(Date dateYear) {
		this.dateYear = dateYear;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "AccountYearBean [id=" + id + ", account=" + account + ", allTime=" + allTime + ", dateYear=" + dateYear
				+ ", ip=" + ip + "]";
	}
	
}
