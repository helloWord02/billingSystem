package com.test_project.operation_sys.bill_mag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test_project.bean.BillBusinessInfoBean;
import com.test_project.operation_sys.bill_mag.service.IBillBusinessInfoService;
import com.test_project.operation_sys.postage_mag.service.IPostageService;
import com.test_project.pojos.PagerBean;

@Controller
@RequestMapping("/bill")
public class BillBusinessInfoController {
	@Resource
	private IBillBusinessInfoService billBusinessInfoServiceImpl;
	
	@RequestMapping("/showBillBusinessInfoPage")
	public ModelAndView showBillBusinessPage(String businessName,String year,String month) {
		ModelAndView mv=new ModelAndView("view/operation/bill/page_business_use");
		mv.addObject("year",year);
		mv.addObject("month",month);
		mv.addObject("businessName",businessName);
		return mv;
	}
	
	@RequestMapping("/showBillBusinessInfoData")
	
	public @ResponseBody PagerBean showBillBusinessInfoData(int page,String year,String month,String businessName) {
		PagerBean pager = new PagerBean(page,5,null);
		Map<String, Object> map = new HashMap<>();
		BillBusinessInfoBean bb = new BillBusinessInfoBean();		
		map.put("year", year);
		map.put("month", month);
		map.put("businessName", businessName);
		pager.setParams(map);
//		System.out.println("View层传递到后台的Pager------------------------------------------------："+pager);
		pager = billBusinessInfoServiceImpl.findBusinessByBusinessAccount(pager);
//		System.out.println("View层得到后台的Pager------------------------------------------------："+pager);		
		return pager;
		
	}

}
