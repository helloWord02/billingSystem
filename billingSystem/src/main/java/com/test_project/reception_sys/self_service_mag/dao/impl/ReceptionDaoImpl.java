package com.test_project.reception_sys.self_service_mag.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BillBusinessInfoBean;
import com.test_project.bean.BusinessBean;
import com.test_project.pojos.PagerBean;
import com.test_project.reception_sys.self_service_mag.dao.IReceptionDao;
import com.test_project.util.BaseDao;

@Repository
public class ReceptionDaoImpl extends BaseDao implements IReceptionDao {

	@Override
	public AccountBean findAccountBean(long id) {
		// TODO Auto-generated method stub	
		AccountBean bean = (AccountBean) getSession().get(AccountBean.class, id);
		return bean;
	}

	@Override
	public AccountBean updateAccountBean(AccountBean account) {
		// TODO Auto-generated method stub
		getSession().update(account);
		return account;
	}

	@Override
	public PagerBean findBillBusinessBeanByPagerBean(PagerBean pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagerBean findBillBusinessInfoBeanByPagerBean(PagerBean pager) {
		// TODO Auto-generated method stub
				
		return null;
	}

}
