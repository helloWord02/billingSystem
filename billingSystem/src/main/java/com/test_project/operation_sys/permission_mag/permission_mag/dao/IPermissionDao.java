package com.test_project.operation_sys.permission_mag.permission_mag.dao;

import java.util.List;

import com.test_project.bean.PermissionBean;
import com.test_project.pojos.PagerBean;

public interface IPermissionDao {

	

	/**
	 * 增加权限信息
	 * @param role
	 * @return
	 */
	public void savePermissionBean(PermissionBean bean);
	/**
	 *删除权限信息
	 * @param role
	 * @return
	 */
	public void delPermissionBean(PermissionBean bean);
	/**
	 * 修改权限信息
	 * @param role
	 * @return
	 */
	public void updPermissionBean(PermissionBean bean);
	/**
	 * 根据权限名查询权限信息
	 * @param role
	 * @return
	 */
	public PermissionBean findPermissionBean(String permissionname);
	/**
	 * 查询id查询权限信息
	 * @param role
	 * @return
	 */
	public PermissionBean findPermissionBeanById(long id);
	/**
	 * 查询所有权限信息
	 * @param role
	 * @return
	 */
	public List<PermissionBean> findPermissions();
	
	/**
	 * 条件查询权限分页
	 * @param role
	 * @return
	 */
	public PagerBean findPagerAccount(PagerBean pager);
}
