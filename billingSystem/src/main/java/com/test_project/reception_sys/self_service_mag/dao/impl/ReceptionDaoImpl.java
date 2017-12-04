package com.test_project.reception_sys.self_service_mag.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
		String month = pager.getParams().get("month").toString();
		String hql = "select count(b.id) from BillBean as b where b.billAccount=:account ";
		if(month != null && !"".equals(month)) {
			hql += " and month(b.date) = " + month;
		}
		Query query = getSession().createQuery(hql);
		query.setString("account", pager.getParams().get("account").toString());
		long total = (Long) query.uniqueResult();
		pager.setTotalRows(Integer.valueOf(String.valueOf(total)));
	
		hql = "From BillBean as b where b.billAccount=:account ";
		if(month != null && !"".equals(month)) {
			hql += "and month(b.date) = " + month;
		}
		query = getSession().createQuery(hql);
		query.setString("account", pager.getParams().get("account").toString());
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<?> datas = query.list();
		pager.setDatas(datas);
		return pager;
	}

	@Override
	public PagerBean findBillBusinessInfoBeanByPagerBean(PagerBean pager) {
		// TODO Auto-generated method stub
				
		return null;
	}

}
