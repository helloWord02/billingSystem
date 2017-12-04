package com.test_project.operation_sys.user_mag.business_mag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BusinessBean;
import com.test_project.operation_sys.user_mag.business_mag.service.IBusinessService;
import com.test_project.pojos.PagerBean;

@Controller
@RequestMapping("/business")
public class BusinessController {
	@Resource
	private IBusinessService IBusinessServiceImpl;
	
	
	@RequestMapping("/buspage")
	public @ResponseBody PagerBean buspage(int page,String businessAccount,String billAccount) {

		Map map=new HashMap();
		map.put("businessAccount", businessAccount);
		map.put("billAccount", billAccount);
		PagerBean pager=new PagerBean(page, 5, map);
		System.out.println("-------------------"+pager);
		PagerBean repage=IBusinessServiceImpl.findBusinessPager(pager);
		System.out.println(repage);
		return repage;
		
	}
	
	@RequestMapping("/findInfo")
	public ModelAndView findInfo(long nowId) {
	ModelAndView mv=new ModelAndView("view/operation/user/business/page_business_info");
	BusinessBean bean=IBusinessServiceImpl.findBusiness(nowId);
	mv.addObject("Businesstinfo",bean);
	return mv;
	
	}
	
	@RequestMapping("/delt")
	public ModelAndView del(long nowId) {
	ModelAndView mv=new ModelAndView("view/operation/user/business/page_business");
	BusinessBean bean= new BusinessBean();
	bean.setId(nowId);
	IBusinessServiceImpl.delBusiness(bean);
	
		return mv;	
	
	}
	@RequestMapping("/updatefind")
	public ModelAndView updatefind(long nowId) {
		ModelAndView mv=new ModelAndView("view/operation/user/business/page_business_upd");
		BusinessBean  bean= IBusinessServiceImpl.findBusiness(nowId);
		 mv.addObject("Businessfind",bean);
		 return mv;
		
	
	}
	
	@RequestMapping(value="/update")
	public ModelAndView update(BusinessBean bus) {
	IBusinessServiceImpl.updBusiness(bus);
	ModelAndView mv=new ModelAndView("view/operation/user/business/page_business");	
	System.out.println("__________________________________________"+mv);
	return mv;
		
	}
	
	@RequestMapping(value="/add")
	public ModelAndView add(BusinessBean bus) {
	IBusinessServiceImpl.saveBusiness(bus);
	ModelAndView mv=new ModelAndView("view/operation/user/business/page_business");	
	System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+mv);
	return mv;
		
	}
	
	
}
