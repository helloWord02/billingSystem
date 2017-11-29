package com.test_project.operation_sys.log_mag.handle_log_mag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.HandLogBean;
import com.test_project.operation_sys.log_mag.handle_log_mag.dao.IHandLogDao;
import com.test_project.operation_sys.log_mag.handle_log_mag.service.IHandLogService;
import com.test_project.pojos.PagerBean;
@Service
public class HandLogServiceImpl  implements IHandLogService {

	@Resource
	private IHandLogDao HandLogDaoImpl;
	@Override
	public void addHandLog(HandLogBean hlBean) {
		// TODO Auto-generated method stub
		HandLogDaoImpl.addHandLog(hlBean);
		
	}

	@Override
	public PagerBean findHandLogByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		return HandLogDaoImpl.findHandLogByPagerBean(pager);
	}

}
