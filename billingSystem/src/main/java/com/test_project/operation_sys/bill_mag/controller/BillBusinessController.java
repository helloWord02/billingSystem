package com.test_project.operation_sys.bill_mag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping("/showBillBusinessData")
	public @ResponseBody PagerBean showBillBusinessData(int pageNum) {

		PagerBean pager = new PagerBean(pageNum, 5, null);
		BillBusinessBean b = new BillBusinessBean();

		b.setBillAccount("账务账号1");
		Map<String, Object> map = new HashMap<>();
		map.put("billAccount", b.getBillAccount());

		System.out.println("封装MAP：" + map.get("billAccount"));
		pager.setParams(map);
		System.out.println("PagerBeanMAP" + pager.getParams().get("billAccount"));
		pager = billBusinessServiceImpl.findAllBusinessByBillAccount(pager);
		System.out.println(pager);
		return pager;

	}

}
