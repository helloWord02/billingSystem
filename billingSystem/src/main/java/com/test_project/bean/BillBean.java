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
 * 账单查询实体Bean(所有账务账号账单)
 * 
 * @author huangjun
 * @version 1.0
 * @created 25-11��-2017 15:09:23
 */
@Entity
@Table(name = "t_bill")
public class BillBean implements Serializable {
	/**
	 * 总费用
	 */
	@Column(name = "all_cost")
	private double allCost;
	
	/**
	 * 账务账号
	 */
	@Column(name = "bill_account", length = 45)
	private String billAccount;
	
	/**
	 * 日期
	 */
	@Column(name = "use_time")
	private Date date;
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name = "hibernate.identity", strategy = "identity")
	@GeneratedValue(generator = "hibernate.identity")
	private long id;
	
	/**
	 * 身份证
	 */
	@Column(name = "idcard")
	private String idcard;
	
	/**
	 * 支付状态
	 */
	
	@Column(name = "pay_state")
	private int payState;
	/**
	 * 支付方式
	 */
	@Column(name = "pay_type", length = 20)
	private String payType;
	/**
	 * 用户名
	 */
	@Column(name = "user_name", length = 20)
	private String userName;

	public BillBean() {

	}

	public double getAllCost() {
		return allCost;
	}

	public void setAllCost(double allCost) {
		this.allCost = allCost;
	}

	public String getBillAccount() {
		return billAccount;
	}

	public void setBillAccount(String billAccount) {
		this.billAccount = billAccount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public int getPayState() {
		return payState;
	}

	public void setPayState(int payState) {
		this.payState = payState;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "BillBean [allCost=" + allCost + ", billAccount=" + billAccount + ", date=" + date + ", id=" + id
				+ ", idcard=" + idcard + ", payState=" + payState + ", payType=" + payType + ", userName=" + userName
				+ "]";
	}

}