package com.test_project.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 账单查询实体Bean(所有账务账号账单)
 * @author huangjun
 * @version 1.0
 * @created 25-11��-2017 15:09:23
 */


public class BillBean {
	
	
	private double allCost;
	private String billAccount;
	private int date;
	private long id;
	private int idcard;
	private int payState;
	private String payType;
	private String userName;

	public BillBean(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

}