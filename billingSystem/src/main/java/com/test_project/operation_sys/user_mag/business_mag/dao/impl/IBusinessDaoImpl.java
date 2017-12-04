package com.test_project.operation_sys.user_mag.business_mag.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.PostageBean;
import com.test_project.operation_sys.user_mag.business_mag.dao.IBusinessDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;
@Repository
public class IBusinessDaoImpl extends BaseDao implements IBusinessDao {

	
	
	public void saveBusiness(BusinessBean bus) {
		// TODO Auto-generated method stub
		getSession().save(bus);
		
		

	}

	
	public void delBusiness(BusinessBean bus) {
		// TODO Auto-generated method stub
		getSession().delete(bus);

	}

	
	public BusinessBean findBusiness(long id) {
		// TODO Auto-generated method stub
		return (BusinessBean) getSession().get(BusinessBean.class, id);
	}

	
	public void updBusiness(BusinessBean bus) {
		// TODO Auto-generated method stub
		getSession().update(bus);

	}


	public PagerBean findBusinessPager(PagerBean Pager) {
		// TODO Auto-generated method stub

		String hql ="select count(b.id) from BusinessBean as b left join  b.account as a where a.billAccount like CONCAT(?,'%')  and b.businessAccount like CONCAT(?,'%') ";
		Query query =getSession().createQuery(hql);
		query.setString(0,Pager.getParams().get("billAccount").toString());
		query.setString(1,Pager.getParams().get("businessAccount").toString());
		System.out.println("--------------------"+Pager);
		long totalRows = (Long) query.uniqueResult();
		Pager.setTotalRows(Integer.valueOf(totalRows+""));
		
		hql="from BusinessBean as b left join fetch  b.account as a  left join fetch b.postage where a.billAccount like CONCAT(?,'%')  and b.businessAccount like CONCAT(?,'%')   ";
		query =getSession().createQuery(hql);
		query.setFirstResult(Pager.getIndex());
		query.setMaxResults(Pager.getRows());
		query.setString(0,Pager.getParams().get("billAccount").toString());
		query.setString(1,Pager.getParams().get("businessAccount").toString());
		
		System.out.println("++++++++++++++++++++++++++++++++++"+Pager.getRows());
		List<BusinessBean> datas  = query.list();
		Pager.setDatas(datas);
		return Pager;
	}


	@Override
	public AccountBean findAccountByname(String name) {
		// TODO Auto-generated method stub
		String hql ="from AccountBean as a where a.billAccount = ?";
		Query query =getSession().createQuery(hql);
		query.setString(0, name);
		
		return (AccountBean) query.list().get(0);
	}


	@Override
	public PostageBean findPostageByname(String name) {
		// TODO Auto-generated method stub
		String hql ="from PostageBean as p where p.postageName = ?";
		Query query =getSession().createQuery(hql);
		query.setString(0, name);
		
		return (PostageBean) query.list().get(0);
	}

}
