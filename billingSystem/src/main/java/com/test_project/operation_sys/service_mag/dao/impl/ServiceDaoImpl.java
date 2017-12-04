package com.test_project.operation_sys.service_mag.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.test_project.bean.ServiceBean;
import com.test_project.operation_sys.service_mag.dao.IServiceDao;
import com.test_project.util.BaseDao;
/**
 * Service(服务器持久层接口实现类)
 * @author Administrator
 *
 */

@Repository
public class ServiceDaoImpl extends BaseDao implements IServiceDao {

	@Override
	public List<ServiceBean> findAllServiceBean(ServiceBean service) {
		// TODO Auto-generated method stub
		String hql = "select new map(s.id as id,s.busniess_account as busniessAccount,s.login_time as loginTime,s.loginout_time as loginoutTime,s.time_long as timeLone) from ServiceBean as s where s.busniess_account like CONCAT(:busniess_account,'%') ";
		Query query = getSession().createQuery(hql);
		query.setProperties(service);		
		return query.list();
	}
	

	public List<ServiceBean> findAllService(Map<String, Integer> map){
		String hql="from ServiceBean s where YEAR(s.loginTime)= :year and MONTH(s.loginTime)= :month";
		Query q=getSession().createQuery(hql);
		q.setProperties(map);
		List<ServiceBean> list=q.list();
		return list;
	}


	@Override
	public void saveRow(ServiceBean bean) {
		// TODO Auto-generated method stub
		getSession().save(bean);
	}
	
	

}
