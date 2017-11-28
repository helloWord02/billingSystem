package com.test_project.operation_sys.admin_mag.service.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.AccountBean;
import com.test_project.operation_sys.admin_mag.dao.IAdminDao;
import com.test_project.operation_sys.admin_mag.service.IAdminService;
import com.test_project.pojos.PagerBean;
@Service
public class AdminServiceImpl implements IAdminService {

	@Resource
	private IAdminDao adminDaoImpl;
	
	@Override
	public AccountBean saveAccountBean(AccountBean account) {
		// TODO Auto-generated method stub
		adminDaoImpl.saveAccountBean(account);
		return account;
	}

	@Override
	public AccountBean deleteAccountBean(AccountBean account) {
		// TODO Auto-generated method stub
		adminDaoImpl.deleteAccountBean(account);
		return account;
	}

	@Override
	public AccountBean findAccountBeanById(long id) {
		// TODO Auto-generated method stub
		
		return adminDaoImpl.findAccountBeanById(id);
	}

	@Override
	public AccountBean updateAccountBean(AccountBean account) {
		// TODO Auto-generated method stub
		adminDaoImpl.updateAccountBean(account);
		return account;
	}

	@Override
	public AccountBean findAccountBeanByName(String accountname) {
		// TODO Auto-generated method stub
		return adminDaoImpl.findAccountBeanByName(accountname);
	}

	@Override
	public PagerBean findPagerAccount(PagerBean pager) {
		// TODO Auto-generated method stub
		return adminDaoImpl.findPagerAccount(pager);
	}

	

}
