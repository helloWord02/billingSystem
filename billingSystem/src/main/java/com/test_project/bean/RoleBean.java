package com.test_project.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



/**
 * this is 角色表
 * @author hdj
 * @version 1.0
 * @created 25-11��-2017 11:02:07
 */
@Entity
@Table(name="t_role")
public class RoleBean {
	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")
	private long id;
	@Column(name="role_name",length=45)
	private String roleName;
	@Column(name="type")
	private int type;
	@OneToMany(targetEntity = PermissionBean.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "t_permission_role", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "permission_id")})
	private Set<PermissionBean> permissions;
	@ManyToMany(targetEntity = AccountBean.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "t_account_role", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "account_id")})
	private Set<AccountBean> billAccounts;

	public RoleBean(){

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Set<PermissionBean> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<PermissionBean> permissions) {
		this.permissions = permissions;
	}

	
	
	public Set<AccountBean> getBillAccounts() {
		return billAccounts;
	}

	public void setBillAccounts(Set<AccountBean> billAccounts) {
		this.billAccounts = billAccounts;
	}

	public Set<String> getPermissionsName() {
        Set<String> list = new HashSet<>();
        Set<PermissionBean> perlist = this.getPermissions();
        for (PermissionBean per : perlist) {
            list.add(per.getPermissionName());
        }
        return list;
}
	@Override
	public String toString() {
		return "RoleBean [id=" + id + ", roleName=" + roleName + ", type=" + type + ", permissions=" + permissions
				+ "]";
	}

}