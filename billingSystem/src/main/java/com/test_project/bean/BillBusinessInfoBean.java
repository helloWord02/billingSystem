package com.test_project.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 业务账单详细信息实体Bean
 * 
 * @author huangjun
 * @version 1.0
 * @created 25-11��-2017 15:09:23
 */
@Entity
@Table(name = "t_bill_business_info")
public class BillBusinessInfoBean implements Serializable {

	/**
	 * 业务账号
	 */
	@Column(name = "business_account", length = 45)
	private String businessAccount;
	/**
	 * id
	 */
	@Id
	@GenericGenerator(name = "hibernate.identity", strategy = "identity")
	@GeneratedValue(generator = "hibernate.identity")
	private int id;
	/**
	 * 退出时间
	 */
	@Column(name = "loginout_time")
	private Date loginoutTime;
	/**
	 * 登陆时间
	 */
	@Column(name = "login_time")
	private Date loginTime;
	/**
	 * 服务器信息
	 */
	@Column(name = "services_info")
	private String servicesInfo;
	/**
	 * 时长
	 */
	@Column(name = "time_long")
	private long timeLong;

	public BillBusinessInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public BillBusinessInfoBean(String businessAccount, Date loginoutTime, Date loginTime, String servicesInfo) {
		super();
		this.businessAccount = businessAccount;
		this.loginoutTime = loginoutTime;
		this.loginTime = loginTime;
		this.servicesInfo = servicesInfo;
	}


	public BillBusinessInfoBean(String businessAccount, int id, Date loginoutTime, Date loginTime,
			String servicesInfo, long timeLong) {
		super();
		this.businessAccount = businessAccount;
		this.id = id;
		this.loginoutTime = loginoutTime;
		this.loginTime = loginTime;
		this.servicesInfo = servicesInfo;
		this.timeLong = timeLong;
	}

	public String getBusinessAccount() {
		return businessAccount;
	}

	public void setBusinessAccount(String businessAccount) {
		this.businessAccount = businessAccount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLoginoutTime() {
		return loginoutTime;
	}

	public void setLogoutTime(Date loginoutTime) {
		this.loginoutTime = loginoutTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getServicesInfo() {
		return servicesInfo;
	}

	public void setServicesInfo(String servicesInfo) {
		this.servicesInfo = servicesInfo;
	}

	public long getTimeLong() {
		return timeLong;
	}

	public void setTimeLong(long timeLong) {
		this.timeLong = timeLong;
	}

	@Override
	public String toString() {
		return "BillBusinessInfoBean [businessAccount=" + businessAccount + ", id=" + id + ", loginoutTime="
				+ loginoutTime + ", loginTime=" + loginTime + ", servicesInfo=" + servicesInfo + ", timeLong="
				+ timeLong + "]";
	}

}