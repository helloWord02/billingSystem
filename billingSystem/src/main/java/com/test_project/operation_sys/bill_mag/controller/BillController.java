package com.test_project.operation_sys.bill_mag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test_project.bean.BillBean;
import com.test_project.operation_sys.bill_mag.service.IBillService;
import com.test_project.pojos.PagerBean;
/**
 * 账务账号总账单Bill
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/bill")
public class BillController {
	
	@Resource
	private IBillService billServiceImpl;
	
	@RequestMapping("/cutpage")
	public @ResponseBody PagerBean showBillData(int pageNum) {
		
		PagerBean pager = new PagerBean(pageNum,5,null);
		
		String year = "";
		String month = "";
		BillBean b = new BillBean();
		b.setBillAccount("账务");
		b.setIdcard("");
		b.setUserName("");
		
		
		
		Map<String, Object> map =  new HashMap<>();
		map.put("billAccount", b.getBillAccount());
		map.put("year", year);
		map.put("month", month);
		map.put("idcard", b.getIdcard());
		map.put("userName", b.getUserName());
		System.out.println("封装MAP"+map.get("billAccount"));
		pager.setParams(map);
		System.out.println("PagerBeanMAP"+pager.getParams().get("billAccount"));
		pager = billServiceImpl.findAllBillAccoutCost(pager);
		System.out.println(pager);
		
		
		return pager;
		
	}
	
}
