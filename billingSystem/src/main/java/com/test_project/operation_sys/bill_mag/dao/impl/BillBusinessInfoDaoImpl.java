package com.test_project.operation_sys.bill_mag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.test_project.bean.BusinessBean;
import com.test_project.bean.ServiceBean;
import com.test_project.operation_sys.bill_mag.dao.IBillBusinessInfoDao;
import com.test_project.operation_sys.service_mag.dao.IServiceDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;
/**
 * 业务账号当月费用明细信息实现类
 * @author huangjun
 *
 */
@Repository
public class BillBusinessInfoDaoImpl extends BaseDao implements IBillBusinessInfoDao {
	
	@Override
	public void saveBusinessCost(BusinessBean businessBean) {
		// TODO Auto-generated method stub
		getSession().save(businessBean);
	}

	@Override
	public PagerBean findBusinessByBusinessAccount(PagerBean pager) {
		// TODO Auto-generated method stub
		/**
		 * 分页信息查询
		 */
		Criteria criteria = getSession().createCriteria(BusinessBean.class);
		criteria.add(Restrictions.like("business_account", pager.getParams().get("business_account").toString()));
		criteria.setProjection(Projections.count("id"));
		int totalRows =  (int) criteria.uniqueResult();
		pager.setTotalRows(totalRows);
		
		/**
		 * 查询具体数据
		 */
		criteria.setProjection(null);
		criteria.setFirstResult(pager.getIndex());
		criteria.setMaxResults(pager.getRows());
		criteria.addOrder(Order.desc("id"));
		List<?> datas = criteria.list();
		pager.setDatas(datas);		
		return pager;
	}

}
