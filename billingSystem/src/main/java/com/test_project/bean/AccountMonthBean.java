package com.test_project.bean;

import java.util.Date;

/**
 * 记录服务器某月使用总时长实体bean
 * @author xl
 *
 */
public class AccountMonthBean {

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
	private Date dateMonth;
	/**
	 * 服务器ip
	 */
	private String ip;
	
	public AccountMonthBean() {
		super();
	}

	public AccountMonthBean(String account, long allTime, Date dateMonth, String ip) {
		super();
		this.account = account;
		this.allTime = allTime;
		this.dateMonth = dateMonth;
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

	public Date getDateMonth() {
		return dateMonth;
	}

	public void setDateMonth(Date dateMonth) {
		this.dateMonth = dateMonth;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "AccountMonthBean [id=" + id + ", account=" + account + ", allTime=" + allTime + ", dateMonth="
				+ dateMonth + ", ip=" + ip + "]";
	}
	
}
