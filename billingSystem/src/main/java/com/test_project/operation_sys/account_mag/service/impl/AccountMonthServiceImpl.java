package com.test_project.operation_sys.account_mag.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.test_project.bean.AccountMonthBean;
import com.test_project.operation_sys.account_mag.dao.IAccountDayDao;
import com.test_project.operation_sys.account_mag.dao.IAccountMonthDao;
import com.test_project.operation_sys.account_mag.service.IAccountMonthService;
import com.test_project.pojos.PagerBean;

@Service
public class AccountMonthServiceImpl implements IAccountMonthService {

	@Resource
	private IAccountDayDao accountDayDaoImpl; 
	@Resource
	private IAccountMonthDao accountMonthDaoImpl; 
	@Override
	public void saveAccountMonth(Date date) {
		// TODO Auto-generated method stub
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String str = format.format(date);
		 String year = str.split("-")[0];
		 String month = str.split("-")[1];
		 AccountMonthBean am =  accountDayDaoImpl.findAccountDayByPage(year,month);
		 am.setDate(date);
		 accountMonthDaoImpl.saveAccountMonth(am);
	}
 
	@Override
	public PagerBean findAccountMonthByPage(PagerBean page) {
		// TODO Auto-generated method stub
		return  accountMonthDaoImpl.findAccountMonthByPage(page);
	}

}
