package com.test_project.operation_sys.bill_mag.controller;

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
	public ModelAndView showBillBusinessPage(String businessName) {
		ModelAndView mv=new ModelAndView("view/operation/bill/page_business_use");		
		mv.addObject("businessName",businessName);
		return mv;
	}
	
	@RequestMapping("/showBillBusinessInfoData")
	
	public @ResponseBody BillBusinessInfoBean showBillBusinessInfoData(int pageNum) {
		
		BillBusinessInfoBean bb = new BillBusinessInfoBean();
		bb.setBusinessAccount("业务账户3");
		
		bb = billBusinessInfoServiceImpl.findBusinessByBusinessAccount(bb);
		System.out.println("详细业务账号信息："+bb);
		
		return bb;
		
	}

}
