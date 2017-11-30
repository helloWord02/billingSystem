package com.test_project.operation_sys.admin_mag.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.test_project.bean.AccountBean;
import com.test_project.bean.RoleBean;
import com.test_project.common_sys.controller.MailSend;
import com.test_project.operation_sys.admin_mag.service.IAdminService;
import com.test_project.pojos.PagerBean;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	@Resource
	private IAdminService adminServiceImpl;
	
	
	@Resource
	private MailSend mailSend;
	
	@RequestMapping(value="/main")
	public @ResponseBody PagerBean getAdmins(int page,int rows) {
		
		PagerBean pager=new PagerBean();
		pager.setPage(page);
		pager.setRows(rows);
		Map m=new HashMap<>();
		m.put("roletype", 2);
		pager.setParams(m);

		PagerBean bean=adminServiceImpl.findPagerAccount(pager);
		
		System.out.println(bean);
		
		return bean;
	}
	@RequestMapping(value="/add")
	public @ResponseBody String add(String realName,String gender,String billAccount,String password,String idCard,String phoneNumber,String cord,String address,String qq,String roles,String mail) {
			try {
				AccountBean bean=new AccountBean();
				bean.setRealName(realName);
				bean.setBillAccount(billAccount);
				bean.setAddress(address);
				bean.setCord(Integer.parseInt(cord));
				bean.setGender(Integer.parseInt(gender));
				bean.setIdCard(idCard);
				bean.setMail(mail);
				bean.setPassword(password);
				bean.setQq(Integer.parseInt(qq));
				bean.setPhoneNumber(phoneNumber);
				RoleBean b=new RoleBean();
				b.setId(Integer.parseInt(roles));
				bean.setRoles(b);
				System.out.println(bean);
				
				adminServiceImpl.saveAccountBean(bean);
				System.out.println("开始发送邮件！！！！");
				mailSend.sendbean(bean);
				bean=null;
				return "0";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return "1";
		}
		
		
		
	}
	@RequestMapping(value="/delete")
	public @ResponseBody String delete(String id) {
		System.out.println(id);
		try {
			AccountBean bean=new AccountBean();
			bean.setId(Long.parseLong(id));
			adminServiceImpl.deleteAccountBean(bean);
			bean=null;
			return "0";
		} catch (Exception e) {
			// TODO: handle exception
			return "1";
		}
	}
	@RequestMapping(value="/upd")
	public ModelAndView upd(String id) {
		ModelAndView mv=new ModelAndView("view/operation/admin/page_admin_upd");		
		mv.addObject("id", id);
		return mv;
		
	}
	@RequestMapping(value="/update")
	public @ResponseBody String update(String realName,
			String gender,String password,String idCard,
			String phoneNumber,String cord,String address,
			String qq,String roles,String mail,String id) {
		try {
			AccountBean bean=new AccountBean();
			bean.setId(Long.parseLong(id));
			bean.setRealName(realName);
			bean.setAddress(address);
			bean.setCord(Integer.parseInt(cord));
			bean.setGender(Integer.parseInt(gender));
			bean.setIdCard(idCard);
			bean.setMail(mail);
			bean.setPassword(password);
			bean.setQq(Integer.parseInt(qq));
			bean.setPhoneNumber(phoneNumber);
			RoleBean b=new RoleBean();
			b.setId(Integer.parseInt(roles));
			bean.setRoles(b);
			
			adminServiceImpl.updateAccountBean(bean);
			bean=null;
		return "0";
	} catch (Exception e) {
		// TODO: handle exception
		return "1";
	}
	}
	@RequestMapping(value="/checkname")
	public @ResponseBody String get(String billAccount) {
		
		AccountBean bean=adminServiceImpl.findAccountBeanByName(billAccount);
		if(bean==null) {
			return "1";
		}else {
			return "0";
		}			
	}
	@RequestMapping(value="/checkinfo")
	public ModelAndView getAccountBean(String id) {
		ModelAndView mv=new ModelAndView("view/operation/admin/page_admin_info");
		AccountBean bean=adminServiceImpl.findAccountBeanById(Long.parseLong(id));
		mv.addObject("bean",bean);
		return mv;
				
	}
	
}
