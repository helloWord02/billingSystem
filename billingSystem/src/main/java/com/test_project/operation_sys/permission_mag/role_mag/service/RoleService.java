package com.test_project.operation_sys.permission_mag.role_mag.service;

import java.util.List;

import com.test_project.bean.RoleBean;
import com.test_project.pojos.PagerBean;


public interface RoleService {

	/**
	 * 增加角色
	 * @param role
	 * @return
	 */
	public RoleBean saveRoleBean(RoleBean role);
	/**
	 * 删除角色
	 * @param role
	 * @return
	 */
	public RoleBean dalRoleBean(RoleBean role);
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	public RoleBean updRoleBean(RoleBean role);
	/**
	 * 条件查询角色分页
	 * @param role
	 * @return
	 */
	public PagerBean findPagerAccount(PagerBean pager);
	/**
	 * 根据角色名查询角色是否存在
	 * @param role
	 * @return
	 */
	public RoleBean findRoleBeanByName(String rolename);
	/**
	 * 根据id查询角色信息
	 * @param role
	 * @return
	 */
	public RoleBean findRoleBeanById(long id);
	/**
	 * 查询所有角色
	 * @param role
	 * @return
	 */
	public List<RoleBean> findRoleBeans();
	
	
	
	
	
}
