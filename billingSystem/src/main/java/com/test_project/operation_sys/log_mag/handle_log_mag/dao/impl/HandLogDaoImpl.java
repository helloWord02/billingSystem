package com.test_project.operation_sys.log_mag.handle_log_mag.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.test_project.bean.HandLogBean;
import com.test_project.operation_sys.log_mag.handle_log_mag.dao.IHandLogDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;
@Repository
public class HandLogDaoImpl extends BaseDao implements IHandLogDao {

	@Override
	public void addHandLog(HandLogBean hlBean) {
		// TODO Auto-generated method stub
		getSession().save(hlBean);
	}

	@Override
	public PagerBean findHandLogByPagerBean(PagerBean pager) {
		// TODO Auto-generated method stub	
		
		String hql="select count(id)  from HandLogBean where magName like concat(:magName,'%') "
				+ " and handTime >= (:beginTime) and  handTime<= (:endTime)";
		Query  query = getSession().createQuery(hql); 
		query.setProperties(pager.getParams());
		long totalRows = (long) query.uniqueResult();	 
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
	
		hql = " From HandLogBean where magName like concat(:magName,'%') "
				+ "and handTime >= (:beginTime) and handTime<= (:endTime)";
		query = getSession().createQuery(hql); 
		query.setProperties(pager.getParams());
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<?> datas = query.list();
		pager.setDatas(datas); 
		
		return pager;
		
	
	}

	
	

}
