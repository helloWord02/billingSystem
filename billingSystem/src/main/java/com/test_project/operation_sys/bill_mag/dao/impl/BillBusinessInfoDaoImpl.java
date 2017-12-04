package com.test_project.operation_sys.bill_mag.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BillBusinessInfoBean;
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
		 * 查询分页信息
		 */	
		System.out.println("Controller传进来的参数Pager:"+pager);
		String hql = "select count(b.id) from BillBusinessInfoBean as b where b.businessAccount = :businessAccount and month(b.loginTime) = :month and year(b.loginTime) = :year";
		Query query = getSession().createQuery(hql);
		String businessAccount = pager.getParams().get("businessName").toString();
		String year = pager.getParams().get("year").toString();
		String month = pager.getParams().get("month").toString();
		query.setString("year", year);
		query.setString("month", month);
		System.out.println("Dao层得到的businessAccount："+businessAccount);
		query.setString("businessAccount", businessAccount);
		
		long totalRows = (Long) query.uniqueResult();
		System.out.println("totalRows:+++++++++++++++totalRows:"+totalRows);
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
		System.out.println("Pager:+++++++++++++++totalRows:"+pager.getTotalRows());
		/**
		 * 查询具体数据
		 */
		hql = "from BillBusinessInfoBean as b where b.businessAccount = :businessAccount and month(b.loginTime) = :month and year(b.loginTime) = :year";
		query = getSession().createQuery(hql);
		query.setString("year", year);
		query.setString("month", month);
		query.setString("businessAccount", businessAccount);
//		Map map = new HashMap<>();
//		map.put("year", year);
//		query.setProperties(map);
		System.out.println("------------------------------------"+query.list());		
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<BillBusinessBean> datas = query.list();
		System.out.println("Dao层查询到的datas数据："+ datas);
		pager.setDatas(datas);
		System.out.println("Dao层查询到的pager数据："+ pager);		
		return pager;
	}

}
