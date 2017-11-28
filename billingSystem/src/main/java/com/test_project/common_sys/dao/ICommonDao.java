package com.test_project.common_sys.dao;

import com.test_project.bean.AccountBean;

public interface ICommonDao {

	/*
	 * 通过id查个人信息展示
	 */
	public AccountBean findAccountBean(AccountBean account);
	/*
	 * 修改个人信息
	 */
	public void updateAccountBean(AccountBean account);

	public AccountBean login(AccountBean account);

}
