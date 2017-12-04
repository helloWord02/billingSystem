package com.test_project.operation_sys.bill_mag.dao.impl;

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

	@Override
	public void saveBusinessInfoBean(BillBusinessInfoBean billInfo) {
		// TODO Auto-generated method stub
		getSession().save(billInfo);
	}

	@Override
	public List<BillBusinessInfoBean> findBillInfoMonth(Map<String, ?> map) {
		
		String hql="from BillBusinessInfoBean  where businessAccount =:businessAccount "
				+ " and year(loginTime)=:year and month(loginTime) = :month";
		Query q=getSession().createQuery(hql);
		q.setString("year", map.get("year").toString());
		q.setString("month", map.get("month").toString());
		q.setString("businessAccount", map.get("businessAccount").toString());
		List<BillBusinessInfoBean>list=q.list();
		return list;
		
	}

	@Override
	public BusinessBean findBUSBeanByAccont(String accont) {
		// TODO Auto-generated method stub
		String hql="from BusinessBean b   where b.businessAccount=:accont ";
		Query q=getSession().createQuery(hql);
		q.setString("accont", accont);
		BusinessBean bean=(BusinessBean) q.uniqueResult();
		return bean;
	}

	@Override
	public List<String> findAllAccontByMonth(Map map) {
		// TODO Auto-generated method stub
		String hql="select b.businessAccount from BillBusinessInfoBean b where year(loginTime)=:year and month(loginTime) = :month group by b.businessAccount";
		Query q=getSession().createQuery(hql);
		q.setString("year", map.get("year").toString());
		q.setString("month", map.get("month").toString());
		List<String> list=q.list();
		return list;
	}

	@Override
	public List<BusinessBean> findAllAccont() {
		// TODO Auto-generated method stub
		String hql="from BusinessBean";
		Query q=getSession().createQuery(hql);
		List<BusinessBean> list=q.list();
		return list;
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
