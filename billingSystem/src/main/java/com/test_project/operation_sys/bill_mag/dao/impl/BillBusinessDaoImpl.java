package com.test_project.operation_sys.bill_mag.dao.impl;

import java.util.List;
import java.util.Map;

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
		System.out.println("totalRows:+++++++++++++++totalRows:"+totalRows);
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
		System.out.println("Pager:+++++++++++++++totalRows:"+pager.getTotalRows());
		/**
		 * 查询具体的数据
		 */
		hql="from BillBusinessBean as b where b.billAccount = :billAccount ";
		query = getSession().createQuery(hql).setString("billAccount", billAccount);		
		System.out.println("------------------------------------"+query.list());		
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<BillBusinessBean> datas = query.list();
		System.out.println("Dao层查询到的datas数据："+ datas);
		pager.setDatas(datas);
		System.out.println("Dao层查询到的pager数据："+ pager);
		return pager;
	}

	@Override
	public void saveBillBusiness(BillBusinessBean buillBusi) {
		// TODO Auto-generated method stub
		getSession().save(buillBusi);
		
	}

	@Override
	public List<BillBusinessBean> findbillBusByaccount(Map map) {
		// TODO Auto-generated method stub
		String hql="from BillBusinessBean b where year(b.dateMonth)=:year and month(b.dateMonth)=:month and b.billAccount=:account ";
		Query q=getSession().createQuery(hql);
		q.setProperties(map);
		 List<BillBusinessBean> list=q.list();
		return list;
	}

}
