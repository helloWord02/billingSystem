package com.test_project.operation_sys.permission_mag.role_mag.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.RoleBean;
import com.test_project.operation_sys.permission_mag.role_mag.dao.IRoleDao;
import com.test_project.operation_sys.permission_mag.role_mag.service.IRoleService;
import com.test_project.pojos.PagerBean;
@Service
public class RoleServiceImpl implements IRoleService {

	@Resource
	private IRoleDao roleDaoImpl;
	
	@Override
	public RoleBean saveRoleBean(RoleBean role) {
		// TODO Auto-generated method stub
		roleDaoImpl.saveRoleBean(role);
		return role;
	}

	@Override
	public RoleBean delRoleBean(RoleBean role) {
		// TODO Auto-generated method stub
		roleDaoImpl.delRoleBean(role);
		return role;
	}

	@Override
	public RoleBean updRoleBean(RoleBean role) {
		// TODO Auto-generated method stub
		roleDaoImpl.updRoleBean(role);
		return role;
	}

	@Override
	public PagerBean findPagerAccount(PagerBean pager) {
		// TODO Auto-generated method stub
		return roleDaoImpl.findPagerAccount(pager);
	}

	@Override
	public RoleBean findRoleBeanByName(String rolename) {
		// TODO Auto-generated method stub
		return roleDaoImpl.findRoleBeanByName(rolename);
	}

	@Override
	public RoleBean findRoleBeanById(long id) {
		// TODO Auto-generated method stub
		return roleDaoImpl.findRoleBeanById(id);
	}

	@Override
	public List<RoleBean> findRoleBeans() {
		// TODO Auto-generated method stub
		return null;
	}

}
