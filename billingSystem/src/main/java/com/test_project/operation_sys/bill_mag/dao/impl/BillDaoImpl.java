package com.test_project.operation_sys.bill_mag.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.test_project.bean.BillBean;
import com.test_project.bean.ServiceBean;
import com.test_project.operation_sys.bill_mag.dao.IBillDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;

@Repository
public class BillDaoImpl extends BaseDao implements IBillDao {

	@Override
	public void saveBillCost(ServiceBean serviceBean) {
		// TODO Auto-generated method stub
		getSession().save(serviceBean);
	}

	@Override
	public PagerBean findAllBillAccoutCost(PagerBean pager) {
		// TODO Auto-generated method stub
		/**
		 * 查询分页信息
		 */
		String year = pager.getParams().get("year").toString();
		String month = pager.getParams().get("month").toString();
		String hql = "select count(b.id) from BillBean as b where b.idcard like CONCAT(? , '%') and b.billAccount like CONCAT(? , '%') and b.userName like CONCAT(?, '%')";
		if(year != null && !"".equals(year)) {
			hql += " and year(b.useTime) = " + year;
		}
		
		if(month != null && !"".equals(month)) {
			hql += " and month(b.useTime) = " + month;
		}
		Query query = getSession().createQuery(hql);		
		query.setString(0, pager.getParams().get("idcard").toString());
		query.setString(1, pager.getParams().get("billAccount").toString());
		query.setString(2, pager.getParams().get("userName").toString());
		long totalRows = (Long) query.uniqueResult();
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
		
		/**
		 * 查询分页具体数据
		 */
		hql = "from BillBean as b where b.idcard like CONCAT(?,'%') and b.billAccount like CONCAT(?,'%') and b.userName like CONCAT(?,'%')";
		if(year != null && !"".equals(year)) {
			hql += "and year(b.useTime) = " + year;
		}
		
		if(month != null && !"".equals(month)) {
			hql += "and month(b.useTime) = " + month;
		}
		query = getSession().createQuery(hql);		
		query.setString(0, pager.getParams().get("idcard").toString());
		query.setString(1, pager.getParams().get("billAccount").toString());
		query.setString(2, pager.getParams().get("userName").toString());
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<?> datas = query.list();
		pager.setDatas(datas);
		return pager;
	}

}
