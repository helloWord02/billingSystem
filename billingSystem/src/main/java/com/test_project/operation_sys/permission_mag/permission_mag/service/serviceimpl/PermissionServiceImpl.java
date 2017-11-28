package com.test_project.operation_sys.permission_mag.permission_mag.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.PermissionBean;
import com.test_project.operation_sys.permission_mag.permission_mag.dao.IPermissionDao;
import com.test_project.operation_sys.permission_mag.permission_mag.service.IPermissionService;
import com.test_project.pojos.PagerBean;
@Service
public class PermissionServiceImpl implements IPermissionService {
	@Resource
	private IPermissionDao permissionDaoImpl;
	
	@Override
	public PermissionBean savePermissionBean(PermissionBean bean) {
		// TODO Auto-generated method stub	
		permissionDaoImpl.savePermissionBean(bean);	
		return bean;
	}

	@Override
	public PermissionBean delPermissionBean(PermissionBean bean) {
		// TODO Auto-generated method stub
		permissionDaoImpl.delPermissionBean(bean);
		return bean;
	}

	@Override
	public PermissionBean updPermissionBean(PermissionBean bean) {
		// TODO Auto-generated method stub
		permissionDaoImpl.updPermissionBean(bean);
		return bean;
	}

	@Override
	public PermissionBean findPermissionBean(String permissionname) {
		// TODO Auto-generated method stub
		return permissionDaoImpl.findPermissionBean(permissionname);
	}

	@Override
	public PermissionBean findPermissionBeanById(long id) {
		// TODO Auto-generated method stub
		return permissionDaoImpl.findPermissionBeanById(id);
	}

	@Override
	public List<PermissionBean> findPermissions() {
		// TODO Auto-generated method stub
		return permissionDaoImpl.findPermissions();
	}

	@Override
	public PagerBean findPagerAccount(PagerBean pager) {
		// TODO Auto-generated method stub
		return permissionDaoImpl.findPagerAccount(pager);
	}

}
