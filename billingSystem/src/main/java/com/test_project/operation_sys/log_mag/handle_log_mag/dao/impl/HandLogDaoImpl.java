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
		
		String hql="select RoleName from RoleBean as r where typr=2";
		Query query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("roleName").toString());
		long totalRows = (Long) query.uniqueResult();
//		query.setMaxResults(pager.getRows());
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
	
		hql = "From RoleBean as r left join fetch h.type as w where w.tyoe like CONCAT(?,'%')";
		query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("roleName").toString());
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<?> datas = query.list();
		pager.setDatas(datas);
		
		return pager;
		
	
	}

	
	

}
