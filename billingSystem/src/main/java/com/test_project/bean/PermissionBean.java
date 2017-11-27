package com.test_project.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



/**
 * this is 权限表
 * @author DELL
 * @version 1.0
 * @created 25-11��-2017 11:02:07
 */
@Entity
@Table(name="t_permission")
public class PermissionBean {
	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")
	private long id;
	@Column(name="permission_name",length=45)
	private String permissionName;
	@Column(name="msg",length=45)
	private String msg;
	@ManyToOne(targetEntity = RoleBean.class)
	@JoinTable(name = "t_permission_role", joinColumns = {@JoinColumn(name = "permission_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private RoleBean roleBean;

	public PermissionBean(){

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	

	public RoleBean getRoleBean() {
		return roleBean;
	}

	public void setRoleBean(RoleBean roleBean) {
		this.roleBean = roleBean;
	}

	@Override
	public String toString() {
		return "PermissionBean [id=" + id + ", permissionName=" + permissionName + ", msg=" + msg + "]";
	}

	

	

}