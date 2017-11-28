package com.test_project.bean;

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
public class BillBusinessInfoBean {
	
	/**
	 * 业务账号
	 */
	@Column(name = "business_account",length = 45)
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
	private ServiceBean servicesInfo;
	/**
	 * 时长
	 */
	@Column(name = "date")
	private long timeLong;

	public BillBusinessInfoBean() {

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

	public ServiceBean getServicesInfo() {
		return servicesInfo;
	}

	public void setServicesInfo(ServiceBean servicesInfo) {
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