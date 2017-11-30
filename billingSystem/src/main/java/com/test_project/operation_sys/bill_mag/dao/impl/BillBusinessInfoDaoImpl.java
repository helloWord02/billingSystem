package com.test_project.operation_sys.bill_mag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

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
	public BillBusinessInfoBean findBusinessByBusinessAccount(BillBusinessInfoBean billBusinessInfo) {	
		// TODO Auto-generated method stub
		System.out.println("传进来的businessAccount:"+billBusinessInfo.getBusinessAccount());
		String hql = "from BillBusinessInfoBean as b where b.businessAccount = :businessAccount";
		Query query = getSession().createQuery(hql);
		query.setString("businessAccount", billBusinessInfo.getBusinessAccount());
		List<BillBusinessInfoBean> list = query.list();
		System.out.println("返回的list-BillBusinessInfoBean:"+list);
		//System.out.println("业务详细信息："+ business);
		System.out.println(list.size());
		billBusinessInfo = list.get(0);
		return billBusinessInfo;
	}

}
