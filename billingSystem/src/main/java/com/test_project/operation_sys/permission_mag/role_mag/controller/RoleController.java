package com.test_project.operation_sys.permission_mag.role_mag.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test_project.bean.AccountBean;
import com.test_project.bean.PermissionBean;
import com.test_project.bean.RoleBean;
import com.test_project.operation_sys.permission_mag.role_mag.service.IRoleService;
import com.test_project.pojos.PagerBean;

@Controller
@RequestMapping(value="/role")
public class RoleController {
	@Resource 
	private IRoleService roleServiceImpl;
	
	@RequestMapping(value="/roles")
	public @ResponseBody List getroles() {
		
		List<RoleBean> list=roleServiceImpl.findRoleBeans();
		System.out.println(list+"========");
		return list;
		
	}
	@RequestMapping(value="/main")
	public @ResponseBody PagerBean getmain(int page,int rows) {
		PagerBean pager=new PagerBean();
		pager.setPage(page);
		pager.setRows(rows);
		PagerBean bean=roleServiceImpl.findPagerAccount(pager);

		return bean;
		
	}
	@RequestMapping(value="/add")
	public @ResponseBody String add(String rolename,String type,@RequestParam(value="pers[]")String[] pers) {
		try {
			System.out.println(rolename);
			System.out.println(type);
			System.out.println(pers);
			Set<PermissionBean> set=new HashSet<>();
			
			for(int i=0;i<pers.length;i++) {
				PermissionBean p=new PermissionBean();
				p.setId(Long.parseLong(pers[i]));
				set.add(p);
			}
			RoleBean b=new RoleBean();
			b.setRoleName(rolename);
			b.setType(Integer.parseInt(type));
			b.setPermissions(set);
			roleServiceImpl.saveRoleBean(b);
			set=null;
			b=null;
			return "0";
		} catch (Exception e) {
			// TODO: handle exception
			return "1";
		}
	}
	@RequestMapping(value="/delete")
	public @ResponseBody String getmain(int id) {
		System.out.println(id+"-------------------------------");
		RoleBean role=new RoleBean();
		role.setId(id);
		try {
			roleServiceImpl.delRoleBean(role);
			role=null;
			return "0";
		} catch (Exception e) {
			// TODO: handle exception
			return "1";
		}

		
	}
	@RequestMapping(value="/upd")
	public ModelAndView upd(String id) {
		ModelAndView mv=new ModelAndView("view/operation/admin/page_role_upd");		
		mv.addObject("id", id);
		return mv;
		
	}
	@RequestMapping(value="/update")
	public @ResponseBody String update(String id,String rolename,String type,@RequestParam(value="pers[]")String[] pers) {
		try {
			Set<PermissionBean> set=new HashSet<>();
			
			for(int i=0;i<pers.length;i++) {
				PermissionBean p=new PermissionBean();
				p.setId(Long.parseLong(pers[i]));
				set.add(p);
			}
			RoleBean b=new RoleBean();
			b.setId(Long.parseLong(id));
			b.setRoleName(rolename);
			b.setType(Integer.parseInt(type));
			b.setPermissions(set);
			roleServiceImpl.updRoleBean(b);
			b=null;
		return "0";
	} catch (Exception e) {
		// TODO: handle exception
		return "1";
	}
	}
	@RequestMapping(value="/checkname")
	public @ResponseBody String get(String rolename) {
		
		RoleBean bean=roleServiceImpl.findRoleBeanByName(rolename);
		if(bean==null) {
			return "0";
		}else {
			return "1";
		}			
	}
	@RequestMapping(value="/checkinfo")
	public ModelAndView getAccountBean(String id) {
		System.out.println(id+"role+++++");
		ModelAndView mv=new ModelAndView("view/operation/admin/page_role_info");
		RoleBean bean=roleServiceImpl.findRoleBeanById(Long.parseLong(id));
		System.out.println(bean);
		mv.addObject("bean",bean);
		return mv;
				
	}
	
}
