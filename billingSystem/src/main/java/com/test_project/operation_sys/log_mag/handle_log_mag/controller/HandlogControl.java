package com.test_project.operation_sys.log_mag.handle_log_mag.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
import org.springframework.web.bind.annotation.ResponseBody;

import com.test_project.operation_sys.log_mag.handle_log_mag.service.IHandLogService;
import com.test_project.pojos.PagerBean;

@Controller
@RequestMapping("/log2")
public class HandlogControl {

	@Resource
	private IHandLogService HandLogServiceImpl;
	
	@RequestMapping("/handLog")

	public @ResponseBody PagerBean findLoginlogBeanByPageBean(int pageNum,String magName,String beginTime,String endTime  ) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		 
		Map params = new HashMap();
		params.put("magName", magName);
		if(beginTime !=null && !("".equals(beginTime))) {
			try {
				params.put("beginTime", sdf.parse(beginTime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				params.put("beginTime", sdf.parse("1990-01-01 00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(endTime !=null && !("".equals(endTime))) {
			try {
				params.put("endTime", sdf.parse(endTime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				params.put("endTime", sdf.parse("2050-01-01 00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		PagerBean pager = new PagerBean(pageNum, 5, params); 
		
		pager = HandLogServiceImpl.findHandLogByPager(pager);
		 
		System.out.println(pager);
		return pager;
		
	}
	
}
