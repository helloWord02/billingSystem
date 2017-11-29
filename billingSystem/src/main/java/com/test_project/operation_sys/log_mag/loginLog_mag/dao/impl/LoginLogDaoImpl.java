package com.test_project.operation_sys.log_mag.loginLog_mag.dao.impl;

import org.springframework.stereotype.Repository;

import com.test_project.bean.LoginLogBean;
import com.test_project.operation_sys.log_mag.loginLog_mag.dao.ILoginLogDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;
@Repository
public class LoginLogDaoImpl extends BaseDao implements ILoginLogDao {


	@Override
	public PagerBean findLoginLogByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLoginLog(LoginLogBean llBean) {
		// TODO Auto-generated method stub
      getSession().save(llBean);
	}

}
