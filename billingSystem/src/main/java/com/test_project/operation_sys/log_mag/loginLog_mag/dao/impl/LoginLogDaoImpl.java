package com.test_project.operation_sys.log_mag.loginLog_mag.dao.impl;

import java.util.List;

import org.hibernate.Query;
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
		 
		String hql = "From LoginLogBean where magName like concat(:magName,'%') "
				+ "and handTime>= (:beginTime) and handTime<= (:endTime)";
		 
		Query query = getSession().createQuery(hql); 
		query.setProperties(pager.getParams());
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<?> datas = query.list();
		pager.setDatas(datas); 
		
		hql = "select count(id) from LoginLogBean where magName like concat(:magName,'%') "
				+ " and handTime>= (:beginTime) and handTime<= (:endTime) ";
		 	 
		query = getSession().createQuery(hql); 
		query.setProperties(pager.getParams());
		long totalRows = (long) query.uniqueResult();	 
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
		    
		return pager;
	}

	@Override
	public void addLoginLog(LoginLogBean llBean) {
		// TODO Auto-generated method stub
      getSession().save(llBean);
	}

}
