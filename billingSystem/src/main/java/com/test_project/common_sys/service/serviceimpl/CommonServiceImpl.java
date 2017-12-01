package com.test_project.common_sys.service.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.AccountBean;
import com.test_project.common_sys.dao.ICommonDao;
import com.test_project.common_sys.service.ICommonService;
@Service
public class CommonServiceImpl implements ICommonService {

	@Resource
	private ICommonDao commonDaoImpl;
	
	@Override
	public AccountBean findAccountBean(AccountBean account) {
		// TODO Auto-generated method stub
		commonDaoImpl.findAccountBean(account);
		return account;
	}

	@Override
	public AccountBean updateAccountBean(AccountBean account) {
		// TODO Auto-generated method stub
		commonDaoImpl.updateAccountBean(account);
		
		return account;
	}

	@Override
	public AccountBean login(AccountBean account) {
		// TODO Auto-generated method stub
		return commonDaoImpl.login(account);
	}

}
