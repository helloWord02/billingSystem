package com.test_project.operation_sys.bill_mag.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.ServiceBean;
import com.test_project.operation_sys.bill_mag.dao.IBillBusinessDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;

/**
 * 账务账号下所有的业务账号当月发生的费用明细信息持久层实现类
 * 
 * @author huangjun
 *
 */
@Repository
public class BillBusinessDaoImpl extends BaseDao implements IBillBusinessDao {

	@Override
	public void saveBillCost(BusinessBean buesiness) {
		// TODO Auto-generated method stub

	}

	@Override
	public PagerBean findAllBusinessByBillAccount(PagerBean pager) {
		// TODO Auto-generated method stub
		/**
		 * 分页信息查询
		 */
		String hql = "select count(b.id) from BillBusinessBean as b where b.billAccount = :billAccount ";
		Query query = getSession().createQuery(hql);
		String billAccount = pager.getParams().get("billAccount").toString();
		System.out.println("Dao层得到的billAccount："+billAccount);
		query.setString("billAccount", billAccount);
		long totalRows = (Long) query.uniqueResult();
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
		/**
		 * 查询具体的数据
		 */
		hql="from BillBusinessBean as b where b.billAccount = :billAccount ";
		billAccount = pager.getParams().get("billAccount").toString();
		query.setString("billAccount", billAccount);
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<BillBusinessBean> datas = query.list();
		pager.setDatas(datas);
		System.out.println("Dao层查询到的数据："+pager);
		return pager;
	}

}
