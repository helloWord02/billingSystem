package com.test_project.operation_sys.account_mag.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.test_project.bean.AccountYearBean;
import com.test_project.operation_sys.account_mag.dao.IAccountMonthDao;
import com.test_project.operation_sys.account_mag.dao.IAccountYearDao;
import com.test_project.operation_sys.account_mag.service.IAccountYearService;
import com.test_project.pojos.PagerBean;

@Service
public class AccountYearServiceImpl implements IAccountYearService {

	@Resource
	private IAccountYearDao accountYearDaoImpl; 
	@Resource
	private IAccountMonthDao accountMonthDaoImpl;
	@Override
	public void saveAccountYear(Date date) {
		// TODO Auto-generated method stub
				 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 String str = format.format(date);
				 String year = str.split("-")[1];
				 List<AccountYearBean> am =  accountMonthDaoImpl.findAccountMonth(year); 
				 for (AccountYearBean AccountYearBean : am) {
					 AccountYearBean.setDate(date);
					 accountYearDaoImpl.saveAccountYear(AccountYearBean); 
				}
	}
		

	@Override
	public PagerBean findAccountYearByPage(PagerBean page) {
		// TODO Auto-generated method stub
		return  accountYearDaoImpl.findAccountYearByPage(page);
	}

}
