package com.test_project.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_handle_log")
public class HandLogBean {
	
	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")	
	private Long id;
	/**
	 * 管理员名称
	 */
	@Column(name="mag_name",length=40)
	private String magName;
	/**
	 * 操作时间
	 */
	@Column(name="hand_time" )
	private Date handTime;
	/**
	 * 操作方法
	 */
	@Column(name="hand_method",length=150)
	private String handMethod;
	/**
	 * 操作参数
	 */
	@Column(name="hand_args",length=50)
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
