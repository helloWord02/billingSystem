package com.test_project.bean;

import java.util.Date;

public class HandLogBean {
	
	private Long id;
	/**
	 * 管理员名称
	 */
	private String magName;
	/**
	 * 操作时间
	 */
	private Date handTime;
	/**
	 * 操作方法
	 */
	private String handMethod;
	/**
	 * 操作参数
	 */
	private String handArgs;
	
	
	public HandLogBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public HandLogBean(String magName, Date handTime, String handMethod, String handArgs) {
		super();
		this.magName = magName;
		this.handTime = handTime;
		this.handMethod = handMethod;
		this.handArgs = handArgs;
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
	public Date getHandTime() {
		return handTime;
	}
	public void setHandTime(Date handTime) {
		this.handTime = handTime;
	}
	public String getHandMethod() {
		return handMethod;
	}
	public void setHandMethod(String handMethod) {
		this.handMethod = handMethod;
	}
	public String getHandArgs() {
		return handArgs;
	}
	public void setHandArgs(String handArgs) {
		this.handArgs = handArgs;
	}
	@Override
	public String toString() {
		return "HandleData [id=" + id + ", magName=" + magName + ", handTime=" + handTime + ", handMethod=" + handMethod
				+ ", handArgs=" + handArgs + "]";
	}
	

}
