package com.test_project.operation_sys.account_mag.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.test_project.bean.AccountMonthBean;
import com.test_project.bean.AccountYearBean;
import com.test_project.operation_sys.account_mag.dao.IAccountMonthDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;

@Repository
public class AccountMonthDaoImpl extends BaseDao implements IAccountMonthDao {

	@Override
	public void saveAccountMonth(AccountMonthBean am) {
		// TODO Auto-generated method stub
		getSession().save(am);
	}

	@Override
	public PagerBean findAccountMonthByPage(PagerBean pager) {
		// TODO Auto-generated method stub
		String month = pager.getParams().get("month").toString();		
		String hql = "select count(id) from AccountMonthBean where year(date)=(?) "
				+ "  and ip like concat(?,'%')";
		if(month!=null && !("".equals(month))) {
			hql = hql + " and month(date)="+month;
		}
		Query query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("year").toString());
		query.setString(1, pager.getParams().get("ip").toString());
		long totalRows = (Long) query.uniqueResult();
	 
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));

		hql = "From AccountMonthBean as d where  year(date)=(?) "   
				 +  " and ip like concat(?,'%')";
		if(month!=null && !("".equals(month))) {
			hql = hql + " and month(date)="+month;
		}
		query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("year").toString());		 
		query.setString(1, pager.getParams().get("ip").toString());
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<AccountMonthBean> datas = query.list();
		pager.setDatas(datas); 
		return pager;
	}

	@Override
	public AccountYearBean findAccountMonth(String year) {
		// TODO Auto-generated method stub
		String hql = "select new Map( d.businessAccount as businessAcount,d.ip as ip,sum(d.allTime) as allTime )"
				+ "from AccountMonthBean as d where year(d.date)=(?) ";
		Query query = getSession().createQuery(hql);
		query = getSession().createQuery(hql);
		query.setString(0,year);
		AccountYearBean ay = (AccountYearBean) query.uniqueResult();	 
		return ay;
	}

}
