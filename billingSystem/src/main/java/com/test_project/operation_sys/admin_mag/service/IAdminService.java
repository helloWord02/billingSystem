package com.test_project.operation_sys.admin_mag.service;


import com.test_project.bean.AccountBean;
import com.test_project.pojos.PagerBean;

public interface IAdminService {
	/**
	 * 增加账务账号，管理员账号，用户账号
	 * @param account
	 * @return
	 */
	public AccountBean saveAccountBean(AccountBean account);
	/**
	 * 删除账务账号，管理员账号
	 * @param account
	 * @return
	 */
	public AccountBean deleteAccountBean(AccountBean account);
	
	/**
	 * 根据账号id查询账务账号，管理员账号
	 * @param account
	 * @return
	 */
	public AccountBean findAccountBeanById(long id);
	/**
	 *	修改账务账号，管理员账号信息
	 * @param account
	 * @return
	 */
	public AccountBean updateAccountBean(AccountBean account);
	
	/**
	 * 根据账号查询账务账号，管理员账号是否重复
	 * @param account
	 * @return
	 */
	public AccountBean findAccountBeanByName(String accountname);
	
	/**
	 * 分页查询账务账号，管理员账号
	 * @param account
	 * @return
	 */
	public PagerBean findPagerAccount(PagerBean pager);

	
	
}
