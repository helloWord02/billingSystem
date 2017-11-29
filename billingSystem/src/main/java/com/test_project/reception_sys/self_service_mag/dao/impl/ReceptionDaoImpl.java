package com.test_project.reception_sys.self_service_mag.dao.impl;

import org.springframework.stereotype.Repository;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BillBusinessInfoBean;
import com.test_project.pojos.PagerBean;
import com.test_project.reception_sys.self_service_mag.dao.IReceptionDao;
import com.test_project.util.BaseDao;

@Repository
public class ReceptionDaoImpl extends BaseDao implements IReceptionDao {

	@Override
	public AccountBean findAccountBean(long id) {
		// TODO Auto-generated method stub		
		return (AccountBean) getSession().get(AccountBean.class, id);
	}

	@Override
	public AccountBean updateAccountBean(AccountBean account) {
		// TODO Auto-generated method stub
		getSession().update(account);
		return account;
	}

	@Override
	public BillBusinessBean findBillBusinessBeanByPagerBean(PagerBean pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BillBusinessInfoBean findBillBusinessInfoBeanByPagerBean(PagerBean pager) {
		// TODO Auto-generated method stub
		return null;
	}

}
