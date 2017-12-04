package com.test_project.operation_sys.user_mag.business_mag.service;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.PostageBean;
import com.test_project.pojos.PagerBean;

public interface IBusinessService {
	/**
	 * 添加业务账号
	 * @param bus
	 */
	public void  saveBusiness(BusinessBean bus);
	/**
	 * 删除业务账号
	 * @param bus
	 */
	public void delBusiness(BusinessBean bus);
	/**
	 * 查询业务账号
	 * @param id
	 * @return
	 */
	public BusinessBean  findBusiness(long id);
	/**
	 * 更改业务账号
	 * @param bus
	 */
	public  void  updBusiness(BusinessBean bus);
	/**
	 * 分页查询业务账号
	 * @param Pager
	 * @return
	 */
	public PagerBean  findBusinessPager(PagerBean Pager );
	
	public AccountBean findAccountByname(String name);
	
	public PostageBean findPostageByname(String name);
}
