package com.test_project.operation_sys.bill_mag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test_project.bean.BillBusinessBean;
import com.test_project.operation_sys.bill_mag.service.IBillBusinessService;
import com.test_project.pojos.PagerBean;

/**
 * 一个账务账号下所有业务账号当月发生的费用明细信息
 * 
 * @author huangjun
 *
 */
@Controller
@RequestMapping("/bill")
public class BillBusinessController {

	@Resource
	private IBillBusinessService billBusinessServiceImpl;
	
	@RequestMapping("/showBillBusinessPage")
	public ModelAndView showBillBusinessPage(String billAccount,String yearOfMonth) {
		ModelAndView mv=new ModelAndView("view/operation/bill/page_business_cost");		
		mv.addObject("acc",billAccount);
		System.out.println("View层得到的yearOfMonth----------------------------------------------"+yearOfMonth);
		String [] strarr = yearOfMonth.split("/");
		System.out.println(strarr[0]);
		System.out.println(strarr[1]);
		String year = strarr[0];
		String month = strarr[1];
		mv.addObject("year",year);
		mv.addObject("month",month);
		mv.addObject("acc",billAccount);
		return mv;
	}
	
	@RequestMapping("/showBillBusinessData")
	public @ResponseBody PagerBean showBillBusinessData(int page,String billaccount,String year,String month) {
		
		PagerBean pager = new PagerBean(page, 5, null);
		
		Map<String, Object> map = new HashMap<>();
		map.put("billAccount", billaccount);
		map.put("year", year);
		map.put("month", month);
		pager.setParams(map);
		System.out.println("ViewAJax传递给后台的Pager数据："+pager);
		pager = billBusinessServiceImpl.findAllBusinessByBillAccount(pager);
		System.out.println("View层：99999999999999999999999999999"+pager);
		return pager;

	}

}
