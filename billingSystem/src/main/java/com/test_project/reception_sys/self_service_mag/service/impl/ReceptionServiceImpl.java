package com.test_project.reception_sys.self_service_mag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BillBusinessInfoBean;
import com.test_project.pojos.PagerBean;
import com.test_project.reception_sys.self_service_mag.dao.IReceptionDao;
import com.test_project.reception_sys.self_service_mag.service.IReceptionService;

@Service
public class ReceptionServiceImpl implements IReceptionService{
	
	  
	@Resource
	private IReceptionDao ReceptionDaoImpl;
	
	@Override
	public AccountBean findAccountBean(long id) {
		// TODO Auto-generated method stub
		return ReceptionDaoImpl.findAccountBean(id);
	}

	@Override
	public AccountBean updateAccountBean(AccountBean account) {
		// TODO Auto-generated method stub
		return ReceptionDaoImpl.updateAccountBean(account);
	}

	@Override
	public PagerBean findBillBusinessBeanByPagerBean(PagerBean pager) {
		// TODO Auto-generated method stub
		return ReceptionDaoImpl.findBillBusinessBeanByPagerBean(pager);
	}

	@Override
	public PagerBean findBillBusinessInfoBeanByPagerBean(PagerBean pager) {
		// TODO Auto-generated method stub
		return ReceptionDaoImpl.findBillBusinessInfoBeanByPagerBean(pager);
	}
	
}
