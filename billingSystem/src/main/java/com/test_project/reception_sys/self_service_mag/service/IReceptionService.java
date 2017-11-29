package com.test_project.reception_sys.self_service_mag.service;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BillBusinessInfoBean;
import com.test_project.pojos.PagerBean;

public interface IReceptionService {
	/*
	 * 通过id查个人信息展示
	 */
	public AccountBean findAccountBean(long id);
	/*
	 * 修改个人信息
	 */
	public AccountBean updateAccountBean(AccountBean account);
	/*
	 * 查询个人账务账号对应的账单
	 */
	public BillBusinessBean findBillBusinessBeanByPagerBean(PagerBean pager);
	/*
	 * 查询对应的业务账号上的费用明细
	 */
	public BillBusinessInfoBean findBillBusinessInfoBeanByPagerBean(PagerBean pager);
}
