package com.test_project.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 服务器信息实体Bean
 * @author huangjun
 * @version 1.0
 * @created 25-11��-2017 15:09:23
 */

public class ServiceBean {

	private String busniessAccount;
	private long id;
	private int ip;
	private Date loginoutTime;
	private Date loginTime;
	private long timeLong;

	public ServiceBean(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

}