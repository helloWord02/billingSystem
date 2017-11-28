package com.test_project.operation_sys.permission_mag.permission_mag.dao.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;


import com.test_project.bean.PermissionBean;
import com.test_project.operation_sys.permission_mag.permission_mag.dao.IPermissionDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;
@Repository
public class PermissionDaoImpl extends BaseDao implements IPermissionDao {

	@Override
	public void savePermissionBean(PermissionBean bean) {
		// TODO Auto-generated method stub
			getSession().save(bean);
	}

	@Override
	public void delPermissionBean(PermissionBean bean) {
		// TODO Auto-generated method stub
		PermissionBean pb=(PermissionBean) getSession().get(PermissionBean.class, bean.getId());
		getSession().delete(pb);
	}
	
	@Override
	public void updPermissionBean(PermissionBean bean) {
		// TODO Auto-generated method stub
		PermissionBean pb=(PermissionBean) getSession().get(PermissionBean.class, bean.getId());
		getSession().update(pb);
	}

	@Override
	public PermissionBean findPermissionBean(String permissionname) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		params.put("name", permissionname);
		String hql = "from PermissionBean as p where p.permissionName = :name";
		Query query1 = getSession().createQuery(hql);
		query1.setProperties(params);
		PermissionBean u=null;

		if(query1.list().size()!=0) {
			u=(PermissionBean) query1.list().get(0);
		}
		return u;
		
	}

	@Override
	public PermissionBean findPermissionBeanById(long id) {
		// TODO Auto-generated method stub
		return (PermissionBean) getSession().get(PermissionBean.class, id);
	}

	@Override
	public List<PermissionBean> findPermissions() {
		// TODO Auto-generated method stub
		String hql = "from PermissionBean";
		Query query1 = getSession().createQuery(hql);
		
		return query1.list();
	}

	@Override
	public PagerBean findPagerAccount(PagerBean pager) {
		// TODO Auto-generated method stub
		String hql="select count(p.id) From PermissionBean as p ";
		Query query = getSession().createQuery(hql);
		Long l=(Long) query.uniqueResult();
		pager.setTotalRows(Integer.valueOf(l+""));
		
		hql = "From PermissionBean as p";
		Query query1 = getSession().createQuery(hql);
		query1.setFirstResult(pager.getIndex());
		query1.setMaxResults(pager.getRows());
		
		
		List<?> data=query1.list();
		pager.setDatas(data);
		return pager;

	}

}
