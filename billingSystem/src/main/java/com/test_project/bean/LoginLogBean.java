package com.test_project.bean;

import java.util.Date;

public class LoginLogBean {
	
	private  Long id;
	/**
	 * 管理员名称
	 */
	private String magName;
	/**
	 * 操作类型
	 */
	private int  handType;
	/**
	 * 操作时间
	 */
	private Date handTime;
	
	
	
	
	public LoginLogBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LoginLogBean(String magName, int handType, Date handTime) {
		super();
		this.magName = magName;
		this.handType = handType;
		this.handTime = handTime;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMagName() {
		return magName;
	}
	public void setMagName(String magName) {
		this.magName = magName;
	}
	public int getHandType() {
		return handType;
	}
	public void setHandType(int handType) {
		this.handType = handType;
	}
	public Date getHandTime() {
		return handTime;
	}
	public void setHandTime(Date handTime) {
		this.handTime = handTime;
	}
	@Override
	public String toString() {
		return "LoginLogBean [id=" + id + ", magName=" + magName + ", handType=" + handType + ", handTime=" + handTime
				+ "]";
	}
	
	


}
