package com.test_project.operation_sys.account_mag.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.AccountDayBean;
import com.test_project.operation_sys.account_mag.dao.IAccountDayDao;
import com.test_project.operation_sys.account_mag.service.IAccountDayService;
import com.test_project.pojos.PagerBean;

@Service
public class AccountDayServiceImpl implements IAccountDayService {

	@Resource
	private IAccountDayDao accountDayDaoImpl; 
	@Override
	public void saveAccountDay( Date date) {
		// TODO Auto-generated method stub
		AccountDayBean ab = new AccountDayBean();
		
		accountDayDaoImpl.saveAccountDay(ab);
	}

	@Override
	public PagerBean findAccountDayByPage(PagerBean page) {
		// TODO Auto-generated method stub
		return accountDayDaoImpl.findAccountDayByPage(page);
	}

}
