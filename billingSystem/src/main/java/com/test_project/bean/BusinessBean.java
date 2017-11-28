package com.test_project.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 业务账号管理
 * @author 
 *
 */
@Entity
@Table(name="t_business")
public class BusinessBean implements Serializable {
	
	private static final long serialVersionUID = -8336650734417213816L;
	@Id
	@GenericGenerator(name="business",strategy="identity")
	@GeneratedValue(generator="business")
	private long id;
	/**
	 * 业务账号
	 */
	@Column(name="business_account",length=20)
	private String businessAccount;
	/**
	 * 密码
	 */
	@Column(name="password",length=20)
	private String  password;
	/**
	 * 状态
	 */
	@Column(name="state")
	private int state;
	/**
	 * ip
	 */
	@Column(name="ip")
	private int ip;
	/**
	 * 账户账号
	 */
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="fk_account_id")
	private AccountBean account;
	/**
	 * 资费
	 */
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="fk_postage_id")
	private PostageBean  postage;
	
	
	public BusinessBean() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getBusinessAccount() {
		return businessAccount;
	}


	public void setBusinessAccount(String businessAccount) {
		this.businessAccount = businessAccount;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public int getIp() {
		return ip;
	}


	public void setIp(int ip) {
		this.ip = ip;
	}


	public AccountBean getAccount() {
		return account;
	}


	public void setAccount(AccountBean account) {
		this.account = account;
	}


	public PostageBean getPostage() {
		return postage;
	}


	public void setPostage(PostageBean postage) {
		this.postage = postage;
	}


	@Override
	public String toString() {
		return "BusinessBean [id=" + id + ", businessAccount=" + businessAccount + ", password=" + password + ", state="
				+ state + ", ip=" + ip + "]";
	}


	
}
