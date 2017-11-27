package com.test_project.bean;

import java.io.Serializable;

/**
 * 业务账号管理
 * @author 
 *
 */
public class BusinessBean implements Serializable {
	
	private static final long serialVersionUID = -8336650734417213816L;
	
	private long id;
	/**
	 * 业务账号
	 */
	private String businessAccount;
	/**
	 * 密码
	 */
	private String  password;
	/**
	 * 状态
	 */
	private int state;
	/**
	 * ip
	 */
	private int ip;
	/**
	 * 账户账号
	 */
	private AccountBean account;
	/**
	 * 资费
	 */
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
