package com.test_project.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * this is 账务账号表 and 管理员表 and 用户表
 * @author hdj
 * @version 1.0
 * @created 25-11��-2017 11:02:07
 */
@Entity
@Table(name="t_account")
public class AccountBean {
	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")
	private long id;
	@Column(name="bill_account",length=45)
	private String billAccount;
	@Column(name="realname",length=20)
	private String realName;
	@Column(name="phone_number",length=32)
	private String phoneNumber;
	@Column(name="password",length=32)
	private String password;
	@Column(name="gender")
	private int gender;
	@Column(name="idcard",length=20)
	private String idCard;
	@Column(name="address",length=45)
	private String address;
	@Column(name="cord")
	private int cord;
	@Column(name="qq")
	private int qq;
	@Column(name="state")
	private int state;
	@Column(name="mail",length=45)
	private String mail;
	@ManyToMany
	@JoinTable(name = "t_account_role", joinColumns = {@JoinColumn(name = "account_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<RoleBean> roles;

	public AccountBean(){

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getBillAccount() {
		return billAccount;
	}

	public void setBillAccount(String billAccount) {
		this.billAccount = billAccount;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCord() {
		return cord;
	}

	public void setCord(int cord) {
		this.cord = cord;
	}

	public int getQq() {
		return qq;
	}

	public void setQq(int qq) {
		this.qq = qq;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Set<RoleBean> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleBean> roles) {
		this.roles = roles;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "AccountBean [id=" + id + ", billAccount=" + billAccount + ", realName=" + realName + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", gender=" + gender + ", idCard=" + idCard + ", address="
				+ address + ", cord=" + cord + ", qq=" + qq + ", state=" + state + ", mail=" + mail + ", roles=" + roles
				+ "]";
	}

	

}