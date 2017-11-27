package com.test_project.operation_sys.user_mag.account_mag.service;

import com.test_project.bean.AccountBean;
import com.test_project.pojos.PagerBean;

public interface IAccountService {
	/**
	 * 添加账务账号
	 * @param acc
	 */
	public void  saveAccount(AccountBean  acc);
	/**
	 * 删除账务账号
	 * @param acc
	 */
	public void delAccount(AccountBean  acc);
	/**
	 * 查询账务账号
	 * @param id
	 */
	public void findAccount(long id);
	/**
	 * 更改账务账号
	 * @param acc
	 */
	public void updAccount(AccountBean  acc);
	/**
	 * 分页查询账务账号
	 * @param Pager
	 * @return
	 */
	public PagerBean findAccountPager(PagerBean Pager);

}
