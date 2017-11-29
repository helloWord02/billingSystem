package com.test_project.operation_sys.account_mag.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.test_project.bean.AccountYearBean;
import com.test_project.operation_sys.account_mag.dao.IAccountYearDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;
@Repository
public class AccountYearDaoImpl extends BaseDao implements IAccountYearDao{

	@Override
	public void saveAccountYear(AccountYearBean ay) {
		// TODO Auto-generated method stub
		getSession().save(ay);
	}

	@Override
	public PagerBean findAccountYearByPage(PagerBean pager) {
		// TODO Auto-generated method stub
		String year = pager.getParams().get("year").toString();	 
		String hql = "select count(id) from AccountYearBean ";
		if(year!=null&&"".equals(year)) {
			hql = hql + " where  year(dateYear)=year(:year) ";
		}
		 
		Query query = getSession().createQuery(hql);
		 
		long totalRows = (Long) query.uniqueResult();
	 
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
		hql = "From AccountYearBean  ";
		if(year!=null&&"".equals(year)) {
			hql = hql + " where  year(dateYear)=year(:year) ";
		}
		query = getSession().createQuery(hql); 
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getPage());
		List<?> datas = query.list();
		pager.setDatas(datas); 
		return pager;
	}

}
