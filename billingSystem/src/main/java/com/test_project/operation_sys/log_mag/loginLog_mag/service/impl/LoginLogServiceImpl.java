package com.test_project.operation_sys.log_mag.loginLog_mag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.LoginLogBean;
import com.test_project.operation_sys.log_mag.loginLog_mag.dao.ILoginLogDao;
import com.test_project.operation_sys.log_mag.loginLog_mag.service.ILoginLogService;
import com.test_project.pojos.PagerBean;
@Service
public class LoginLogServiceImpl implements ILoginLogService {

	@Resource
	private ILoginLogDao LoginLogDaoImpl;
	@Override
	public PagerBean findLoginLogByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		return LoginLogDaoImpl.findLoginLogByPager(pager);
	}

	@Override
	public void addLoginLog(LoginLogBean llBean) {
		// TODO Auto-generated method stub
		LoginLogDaoImpl.addLoginLog(llBean);
	}

}
