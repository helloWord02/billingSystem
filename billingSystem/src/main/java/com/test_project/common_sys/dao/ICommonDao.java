package com.test_project.common_sys.dao;

import com.test_project.bean.AccountBean;

public interface ICommonDao {
	/**
	 * 通过id查个人信息展示
	 */
	public AccountBean findAccountBean(AccountBean account);
	/**
	 * 修改密码
	 */
	public AccountBean updateAccountBean(AccountBean account);
	
	/**
	 * 账务账号，管理员账号，登录
	 * @param account
	 * @return
	 */
	public AccountBean login(AccountBean account);
}
