package com.test_project.operation_sys.user_mag.account_mag.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test_project.bean.AccountBean;
import com.test_project.bean.PostageBean;
import com.test_project.operation_sys.user_mag.account_mag.service.IAccountService;
import com.test_project.pojos.PagerBean;

@Controller
@RequestMapping("/account")
public class AccController {
	
	@Resource
	private IAccountService IAccountServiceImpl;
	
	@RequestMapping("/conpage")
	public @ResponseBody PagerBean conpage(int page,String realName,String billAccount,String idCard) {
		System.out.println("-----------"+realName);
		System.out.println("------------"+billAccount);
		System.out.println("---------------"+idCard);
		Map map=new HashMap();
		map.put("realName", realName);
		map.put("billAccount", billAccount);
		map.put("idCard",idCard);	
		PagerBean pager=new PagerBean(page, 5, map);
		System.out.println(pager);
		PagerBean repage=IAccountServiceImpl.findAccountPager(pager);
		System.out.println(repage);
		return repage;
		
	}
	@RequestMapping("/findInfo")
	public ModelAndView findInfo(long nowId) {
	ModelAndView mv=new ModelAndView("view/operation/user/account/page_account_number_info");
	AccountBean bean=IAccountServiceImpl.findAccount(nowId);
	mv.addObject("Accountinfo",bean);
	return mv;
	
	}
	@RequestMapping("/delt")
	public ModelAndView del(long nowId) {
	ModelAndView mv=new ModelAndView("view/operation/user/account/page_account_number");
	AccountBean bean= new AccountBean();
	bean.setId(nowId);
	IAccountServiceImpl.delAccount(bean);
	
		return mv;	
		
	}
	@RequestMapping("/updatefind")
	public ModelAndView updatefind(long nowId) {
		ModelAndView mv=new ModelAndView("view/operation/user/account/page_account_number_upd");
		AccountBean bean=IAccountServiceImpl.findAccount(nowId);
		 mv.addObject("Accountfind",bean);
		 return mv;
		
	
	}
	
	
	@RequestMapping(value="/update")
	public ModelAndView update(AccountBean acc) {
	IAccountServiceImpl.updAccount(acc);
	ModelAndView mv=new ModelAndView("view/operation/user/account/page_account_number");	
	System.out.println("__________________________________________"+mv);
	return mv;
		
	}
	
	@RequestMapping(value="/add")
	public ModelAndView add(AccountBean acc) {
	IAccountServiceImpl.saveAccount(acc);
	ModelAndView mv=new ModelAndView("view/operation/user/account/page_account_number");	
	System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+mv);
	return mv;
		
	}
	
	
	
	
	
	
	
	

}
