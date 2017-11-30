package com.test_project.operation_sys.bill_mag.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test_project.bean.BillBean;
import com.test_project.operation_sys.bill_mag.service.IBillService;
import com.test_project.pojos.PagerBean;

/**
 * 账务账号总账单Bill
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/bill")
public class BillController {

	@Resource
	private IBillService billServiceImpl;

	@RequestMapping("/cutpage")
	public @ResponseBody PagerBean showBillData(int page,String idcard,String billAccount,String userName,String year,String month) {

		PagerBean pager = new PagerBean(page, 5, null);
		Map<String, Object> map = new HashMap<>();
		map.put("billAccount",billAccount);
		map.put("year", year);
		map.put("month", month);
		map.put("idcard", idcard);
		map.put("userName", userName);
		map.put("year", year);
		map.put("month", month);
		System.out.println("封装MAP" + map.get("billAccount"));
		pager.setParams(map);
		System.out.println("PagerBeanMAP" + pager.getParams().get("billAccount"));		
		pager = billServiceImpl.findAllBillAccoutCost(pager);
		
		System.out.println(pager);
		return pager;
	}
	
}
