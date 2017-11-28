package com.test_project.common_sys.dao.daoimpl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;



import com.test_project.bean.AccountBean;
import com.test_project.common_sys.dao.ICommonDao;
import com.test_project.util.BaseDao;

public class CommonDaoImpl extends BaseDao implements ICommonDao {

	@Override
	public AccountBean findAccountBean(AccountBean account) {
		// TODO Auto-generated method stub
		
		return (AccountBean) getSession().get(AccountBean.class, account.getId());
	}

	@Override
	public void updateAccountBean(AccountBean account) {
		// TODO Auto-generated method stub
		AccountBean ab=(AccountBean) getSession().get(AccountBean.class, account.getId());
		ab.setPassword(account.getPassword());
		getSession().update(ab);
	}

	@Override
	public AccountBean login(AccountBean account) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		params.put("name", account.getBillAccount());
		params.put("pwd", account.getPassword());
		AccountBean a=null;
		String hql = "from AccountBean A where  A.billAccount=:name and A.password=:pwd";
		Query query1 = getSession().createQuery(hql);
		query1.setProperties(params);
		
		
		
		if(query1.list().size()!=0) {
			a=(AccountBean) query1.list().get(0);
		}
		return a;
		
	}

}
