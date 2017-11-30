package com.test_project.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 * this is 权限表
 * @author DELL
 * @version 1.0
 * @created 25-11��-2017 11:02:07
 */
@Entity
@Table(name="t_permission")
@JsonIgnoreProperties(value= {"roleBean"})  
public class PermissionBean implements Serializable{
	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")
	private long id;
	@Column(name="permission_name",length=45)
	private String permissionName;
	@Column(name="msg",length=45)
	private String msg;
	@ManyToMany
	@JoinTable(name = "t_permission_role", joinColumns = {@JoinColumn(name = "permission_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<RoleBean> role;

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

	

	public Set<RoleBean> getRole() {
		return role;
	}

	public void setRole(Set<RoleBean> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "PermissionBean [id=" + id + ", permissionName=" + permissionName + ", msg=" + msg + "]";
	}

	

	

	

	

}