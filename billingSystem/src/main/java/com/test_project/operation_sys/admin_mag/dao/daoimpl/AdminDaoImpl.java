package com.test_project.operation_sys.admin_mag.dao.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.test_project.bean.AccountBean;
import com.test_project.operation_sys.admin_mag.dao.IAdminDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;

@Repository
public class AdminDaoImpl extends BaseDao implements IAdminDao {

	@Override
	public void saveAccountBean(AccountBean account) {
		// TODO Auto-generated method stub
			getSession().save(account);
	}

	@Override
	public void deleteAccountBean(AccountBean account) {
		// TODO Auto-generated method stub
		AccountBean ab=(AccountBean) getSession().get(AccountBean.class, account.getId());
		getSession().delete(ab);
	}

	@Override
	public AccountBean findAccountBeanById(long id) {
		// TODO Auto-generated method stub

		return (AccountBean) getSession().get(AccountBean.class, id);
	}

	@Override
	public void updateAccountBean(AccountBean account) {
		// TODO Auto-generated method stub
		AccountBean ab=(AccountBean) getSession().get(AccountBean.class, account.getId());
		if(account.getPassword()!=null && !"".equals(account.getPassword())) {
			ab.setPassword(account.getPassword());
		}
		if(account.getPhoneNumber()!=null && !"".equals(account.getPhoneNumber())) {
			ab.setPhoneNumber(account.getPhoneNumber());
		}
		if(account.getAddress()!=null && !"".equals(account.getAddress())) {
			ab.setAddress(account.getAddress());
		}
		if(account.getCord()!=0) {
			ab.setCord(account.getCord());
		}
		if(account.getMail()!=null && !"".equals(account.getMail())) {
			ab.setMail(account.getMail());
		}
		if(account.getQq()!=0) {
			ab.setQq(account.getQq());
		}
		getSession().update(ab);
	}

	@Override
	public AccountBean findAccountBeanByName(String accountname) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		params.put("name", accountname);
		String hql = "from AccountBean a where a.billAccount = :name";
		Query query1 = getSession().createQuery(hql);
		query1.setProperties(params);
		AccountBean u=null;

		if(query1.list().size()!=0) {
			u=(AccountBean) query1.list().get(0);
		}
		return u;
	
	}

	@Override
	public PagerBean findPagerAccount(PagerBean pager) {
		// TODO Auto-generated method stub
		String hql="select count(a.id) From AccountBean as a join RoleBean as r  where r.type =:roletype";
		Query query = getSession().createQuery(hql);
		query.setProperties(pager.getParams());
		Long l=(Long) query.uniqueResult();
		pager.setTotalRows(Integer.valueOf(l+""));
		
		hql = "From AccountBean as a join RoleBean as r  where r.type =:roletype";
		Query query1 = getSession().createQuery(hql);
		query1.setProperties(pager.getParams());
		query1.setFirstResult(pager.getIndex());
		query1.setMaxResults(pager.getRows());
		
		
		List<?> data=query1.list();
		pager.setDatas(data);
		return pager;
	}

	

}
