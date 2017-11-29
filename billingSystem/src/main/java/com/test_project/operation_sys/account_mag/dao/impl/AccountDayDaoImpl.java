package com.test_project.operation_sys.account_mag.dao.impl;

 
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.test_project.bean.AccountDayBean;
import com.test_project.bean.AccountMonthBean;
import com.test_project.operation_sys.account_mag.dao.IAccountDayDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;

@Repository
public class AccountDayDaoImpl extends BaseDao implements IAccountDayDao {

	@Override
	public void saveAccountDay(AccountDayBean ab) {
		// TODO Auto-generated method stub
		getSession().save(ab);
	}

	@Override
	public PagerBean findAccountDayByPage(PagerBean pager) {
		// TODO Auto-generated method stub
		String hql = "select count(id) from AccountDayBean where year(dateMonth)=year(?) "
				+ "  and month(dateMonth)=month(?) and ip =(?)";
		Query query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("year").toString());
		query.setString(1, pager.getParams().get("month").toString());
		query.setString(2, pager.getParams().get("ip").toString());
		
		long totalRows = (Long) query.uniqueResult();
	 
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));

		hql = "From AccountDayBean where year(dateMonth)=year(?) "
				+ " and month(dateMonth)=month(?) and ip =(?)";
		query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("year").toString());
		query.setString(1, pager.getParams().get("month").toString());
		query.setString(2, pager.getParams().get("ip").toString());
		
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getPage());
		List<?> datas = query.list();
		pager.setDatas(datas); 
		return pager;
		
	}

	@Override
	public AccountMonthBean findAccountDayByPage(String month) {
		// TODO Auto-generated method stub		
		String hql = "select new Map( d.businessAccount as businessAcount,d.ip as ip,sum(d.allTime) as allTime )"
				+ "from AccountDayBean as d where month(d.dateDay)=month(?) ";
		Query query = getSession().createQuery(hql);
		query = getSession().createQuery(hql);
		query.setString(0,month);
		AccountMonthBean am = (AccountMonthBean) query.uniqueResult();	 
		return am;
	}

}
