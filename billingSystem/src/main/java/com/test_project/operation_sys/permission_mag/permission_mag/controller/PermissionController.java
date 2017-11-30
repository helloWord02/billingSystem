package com.test_project.operation_sys.permission_mag.permission_mag.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test_project.bean.PermissionBean;

import com.test_project.operation_sys.permission_mag.permission_mag.service.IPermissionService;
import com.test_project.pojos.PagerBean;

@Controller
@RequestMapping(value="/permission")
public class PermissionController {
	@Resource 
	private IPermissionService permissionServiceImpl;
	
	@RequestMapping(value="/permissions")
	public @ResponseBody List getPermissionBeans() {
		
		List<PermissionBean> list=permissionServiceImpl.findPermissions();
		System.out.println(list.size()+"========");
		return list;
		
	}
	@RequestMapping(value="/main")
	public @ResponseBody PagerBean getPagerPer(int page,int rows) {
		PagerBean pager=new PagerBean();
		pager.setPage(page);
		pager.setRows(rows);
		
		PagerBean p=permissionServiceImpl.findPagerAccount(pager);
		
		return p;
		
	}
	@RequestMapping(value="/add")
	public @ResponseBody String add(String pername,String perinfo) {
		try {
			PermissionBean bean=new PermissionBean();
			bean.setPermissionName(pername);
			bean.setMsg(perinfo);
			permissionServiceImpl.savePermissionBean(bean);
			bean=null;
			return "0";
		} catch (Exception e) {
			// TODO: handle exception
			return "1";
		}
	}
	@RequestMapping(value="/delete")
	public @ResponseBody String getmain(int id) {
	
		PermissionBean  pb=new PermissionBean();
		pb.setId(id);
		try {
			permissionServiceImpl.delPermissionBean(pb);
			pb=null;
			return "0";
		} catch (Exception e) {
			// TODO: handle exception
			return "1";
		}

		
	}
	@RequestMapping(value="/upd")
	public ModelAndView upd(String id) {
		ModelAndView mv=new ModelAndView("view/operation/admin/page_permission_upd");		
		mv.addObject("id", id);
		return mv;
		
	}
	@RequestMapping(value="/update")
	public @ResponseBody String update(String id,String pername,String perinfo) {

		try {
			PermissionBean bean=new PermissionBean();
			bean.setId(Long.parseLong(id));
			bean.setPermissionName(pername);
			bean.setMsg(perinfo);
			permissionServiceImpl.updPermissionBean(bean);
			bean=null;
			return "0";
	} catch (Exception e) {
		// TODO: handle exception
		return "1";
	}
	}
	@RequestMapping(value="/checkname")
	public @ResponseBody String get(String permissionname) {
		
		PermissionBean bean=permissionServiceImpl.findPermissionBean(permissionname);
		if(bean==null) {
			return "0";
		}else {
			return "1";
		}			
	}
	
}
