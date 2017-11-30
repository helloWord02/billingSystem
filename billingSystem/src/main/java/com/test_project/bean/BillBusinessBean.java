package com.test_project.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 业务账号实体Bean
 * 
 * @author huangjun
 * @version 1.0
 * @created 25-11��-2017 15:09:23
 */
@Entity
@Table(name = "t_bill_business")
public class BillBusinessBean implements Serializable {

	/**
	 * 账务账号
	 */
	@Column(name = "bill_account", length = 45)
	private String billAccount;
	/**
	 * 费用
	 */
	@Column(name = "cost")
	private double cost;
	/**
	 * id
	 */
	@Id
	@GenericGenerator(name = "hibernate.identity", strategy = "identity")
	@GeneratedValue(generator = "hibernate.identity")
	private long id;
	/**
	 * 资费名称
	 */
	@Column(name = "postage_name", length = 45)
	private String postageName;
	/**
	 * 服务器信息
	 */
	@Column(name = "service", length = 45)
	private String service;
	/**
	 * 时长
	 */
	@Column(name = "time_long")
	private long timeLong;

	public BillBusinessBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillBusinessBean(String billAccount, double cost, long id, String postageName, String service,
			long timeLong) {
		super();
		this.billAccount = billAccount;
		this.cost = cost;
		this.id = id;
		this.postageName = postageName;
		this.service = service;
		this.timeLong = timeLong;
	}

	public String getBillAccount() {
		return billAccount;
	}

	public void setBillAccount(String billAccount) {
		this.billAccount = billAccount;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPostageName() {
		return postageName;
	}

	public void setPostageName(String postageName) {
		this.postageName = postageName;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public long getTimeLong() {
		return timeLong;
	}

	public void setTimeLong(long timeLong) {
		this.timeLong = timeLong;
	}

	@Override
	public String toString() {
		return "BillBusinessBean [billAccount=" + billAccount + ", cost=" + cost + ", id=" + id + ", postageName="
				+ postageName + ", service=" + service + ", timeLong=" + timeLong + "]";
	}

}