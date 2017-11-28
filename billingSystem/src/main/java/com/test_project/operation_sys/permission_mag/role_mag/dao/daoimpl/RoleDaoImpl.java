package com.test_project.operation_sys.permission_mag.role_mag.dao.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;


import com.test_project.bean.RoleBean;
import com.test_project.operation_sys.permission_mag.role_mag.dao.IRoleDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;
@Repository
public class RoleDaoImpl extends BaseDao implements IRoleDao {

	@Override
	public void saveRoleBean(RoleBean role) {
		// TODO Auto-generated method stub
			getSession().save(role);
	}

	@Override
	public void delRoleBean(RoleBean role) {
		// TODO Auto-generated method stub
		RoleBean rb=(RoleBean) getSession().get(RoleBean.class, role.getId());
		getSession().delete(rb);
	}

	@Override
	public void updRoleBean(RoleBean role) {
		// TODO Auto-generated method stub
		RoleBean rb=(RoleBean) getSession().get(RoleBean.class, role.getId());
		if(role.getRoleName()!=null && !"".equals(role.getRoleName())) {
			rb.setRoleName(role.getRoleName());
		}
		if(role.getType()!=0) {
			rb.setType(role.getType());
		}
		if(role.getPermissions()!=null) {
			rb.setPermissions(role.getPermissions());
		}
		
		getSession().update(rb);
	}

	@Override
	public PagerBean findPagerAccount(PagerBean pager) {
		// TODO Auto-generated method stub
		String hql="select count(p.id) From RoleBean as p ";
		Query query = getSession().createQuery(hql);
		Long l=(Long) query.uniqueResult();
		pager.setTotalRows(Integer.valueOf(l+""));
		
		hql = "From RoleBean as p";
		Query query1 = getSession().createQuery(hql);
		query1.setFirstResult(pager.getIndex());
		query1.setMaxResults(pager.getRows());
		
		
		List<?> data=query1.list();
		pager.setDatas(data);
		return pager;

	}

	@Override
	public RoleBean findRoleBeanByName(String rolename) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		params.put("name", rolename);
		String hql = "from RoleBean as r where r.roleName = :name";
		Query query1 = getSession().createQuery(hql);
		query1.setProperties(params);
		RoleBean u=null;

		if(query1.list().size()!=0) {
			u=(RoleBean) query1.list().get(0);
		}
		return u;
	}

	@Override
	public RoleBean findRoleBeanById(long id) {
		// TODO Auto-generated method stub
		
		return (RoleBean) getSession().get(RoleBean.class, id);
	}

	@Override
	public List<RoleBean> findRoleBeans() {
		// TODO Auto-generated method stub
		String hql = "from RoleBean";
		Query query1 = getSession().createQuery(hql);
		
		return query1.list();
	}

}
