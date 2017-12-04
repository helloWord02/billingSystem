package com.test_project.operation_sys.user_mag.account_mag.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.test_project.bean.AccountBean;
import com.test_project.operation_sys.user_mag.account_mag.dao.IAccountDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;
@Repository
public class IAccountDaoImpl extends BaseDao implements IAccountDao {

	
	public void saveAccount(AccountBean acc) {
		// TODO Auto-generated method stub
		getSession().save(acc);

	}

	
	public void delAccount(AccountBean acc) {
		// TODO Auto-generated method stub
		getSession().delete(acc);

	}

	
	public AccountBean findAccount(long id) {
		// TODO Auto-generated method stub
		return (AccountBean) getSession().get(AccountBean.class, id);
	}

	
	public void updAccount(AccountBean acc) {
		// TODO Auto-generated method stub
		getSession().update(acc);

	}


	public PagerBean findAccountPager(PagerBean Pager) {
		// TODO Auto-generated method stub
	
		String hql ="select count(a.id) from AccountBean as a where a.realName like CONCAT(?,'%')  and a.billAccount like CONCAT(?,'%')  and a.idCard like CONCAT(?,'%')";
		Query query =getSession().createQuery(hql);
		query.setString(0,Pager.getParams().get("realName").toString());
		query.setString(1,Pager.getParams().get("billAccount").toString());
		query.setString(2,Pager.getParams().get("idCard").toString());
		
		System.out.println("--------------------"+Pager);
		long totalRows = (Long) query.uniqueResult();
		Pager.setTotalRows(Integer.valueOf(totalRows+""));
		
		hql="from AccountBean as a  where a.realName like CONCAT(?,'%')  and a.billAccount like CONCAT(?,'%')  and a.idCard like CONCAT(?,'%')";
		query = getSession().createQuery(hql);
		query.setFirstResult(Pager.getIndex());
		query.setMaxResults(Pager.getRows());
		query.setString(0,Pager.getParams().get("realName").toString());
		query.setString(1,Pager.getParams().get("billAccount").toString());
		query.setString(2,Pager.getParams().get("idCard").toString());
		List<?> datas  = query.list();
		System.out.println("***************************************************************");
		System.out.println(Pager.getRows());
		Pager.setDatas(datas);
		return Pager;
		
	
	}

}
