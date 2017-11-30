package com.test_project.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 记录服务器某年使用总时长实体bean
 * @author xl
 *
 */
@Entity
@Table(name="t_account_year")
public class AccountYearBean {

	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")	
	private long id;
	/**
	 * 业务账号
	 */
	@Column(name="business_account",length=40)
	private String account;
	
	/**
	 * 某年总时长
	 */
	@Column(name="all_time",length=20)
	private long allTime;
	/**
	 * 查询时间（具体某年）
	 * 
	 */
	@Column(name="date_year")
	private Date date ;
	/**
	 * 服务器ip
	 */
	@Column(name="ip",length=40 )
	private String ip;
	
	public AccountYearBean() {
		super();
	}

	public AccountYearBean(String account, long allTime, Date dateYear, String ip) {
		super();
		this.account = account;
		this.allTime = allTime;
		this.date  = dateYear;
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

	public Date getDate () {
		return date ;
	}

	public void setDate (Date dateYear) {
		this.date  = dateYear;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "AccountYearBean [id=" + id + ", account=" + account + ", allTime=" + allTime + ", date =" + date 
				+ ", ip=" + ip + "]";
	}
	
}
